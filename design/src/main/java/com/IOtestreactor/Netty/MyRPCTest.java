package com.IOtestreactor.Netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.Mapping;
import org.junit.Test;
import org.omg.CORBA.portable.ResponseHandler;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author hx
 * @createTime 2021/1/24 9:47
 * @option
 * @description
 *  1.假设一个需求,写一个rpc
 *  2.来回通信,链接数量, 拆包,?
 *  3.动态代理, 序列化,协议封装.
 *  4.连接池
 *  rpc: 就行调用本地方法一样调用远程的方法, 面向java 就是无所谓的,面向interface开发
 */
public class MyRPCTest {

    @Test
    public void startServer(){
        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup work = boss;

        ServerBootstrap sbs = new ServerBootstrap();
        ChannelFuture bind = sbs.group(boss, work)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        System.out.println("server accept client port : " + ch.remoteAddress().getPort());
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new ServerRequestHandler());
                    }
                }).bind(new InetSocketAddress("localhost", 9090));
        try {
            bind.sync().channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    //consumer
    @Test
    public  void get(){
        new Thread(()->{
            startServer();
        }).start();
        System.out.println("server started........");



        //动态代理
        Car cat = proxyGet(Car.class);
        cat.ooxx("hello");



       /* Fly fly = proxyGet(Fly.class);
        fly.xxoo("hello");*/

    }


    public static <T>T proxyGet(Class<T> interfaceInfo){

        ClassLoader loader = interfaceInfo.getClassLoader();
        Class<?>[] methodInfo = {interfaceInfo};


        return (T) Proxy.newProxyInstance(loader, methodInfo, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                如何设计consumer对于provider的嗲用过程
//                1.调用服务,方法,参数,== > 封装成为message;[content]
                String name = interfaceInfo.getName();
                String methodName = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                MyContent content = new MyContent();

                content.setArgs(args);
                content.setName(name);
                content.setMethodName(methodName);
                content.setParameterTypesl(parameterTypes);

                ByteArrayOutputStream out= new ByteArrayOutputStream();
                ObjectOutputStream oout = new ObjectOutputStream(out);
                oout.writeObject(content);
                byte[] msgBody = out.toByteArray();


//                2.requestID + Message + 本地缓存
//                协议: [header<> ] [msgBody]
                MyHeader header = createHeader(msgBody);
                out.reset();
                oout  = new ObjectOutputStream(out);
                oout.writeObject(header);
                byte[] msgHeader = out.toByteArray();


//                3.连接池,::取得链接
                ClientFactory factory = ClientFactory.getFactory();
                NioSocketChannel clientChannnel = factory.getClient(new InetSocketAddress("localhost", 9090));
//                4.发送-->走IO out  ==>走netty,事件驱动
                ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.directBuffer(msgHeader.length + msgBody.length);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                long id = header.getRequestID();
                ResponeHandler.addCallBack(id, new Runnable() {
                    @Override
                    public void run() {
                        countDownLatch.countDown();
                    }
                });

                byteBuf.writeBytes(msgHeader);
                byteBuf.writeBytes(msgBody);
                ChannelFuture channelFuture = clientChannnel.writeAndFlush(byteBuf);
                channelFuture.sync();
                //io是双向的,看似有个sync仅代表out


                countDownLatch.await();
//                5.如果从IO,未来回来了,如何将代码执行到这个
//                (睡眠,回调, 如何让线程停下来,你还能让他继续.)

                return null;
            }
        });
    }

    public static MyHeader createHeader(byte[] msg){
        MyHeader header = new MyHeader();

        int size = msg.length;
        int f = 0x14141414;
        long requestId = Math.abs(UUID.randomUUID().getLeastSignificantBits());

        header.setFlag(f);
        header.setDataLen(size);
        header.setRequestID(requestId);
        return header;
    }

}


interface Car {
    public void ooxx(String msg);
}
interface Fly{
    public void xxoo(String msg);
}

class  ClientFactory{
    int poolsize = 1;
    Random rand = new Random();
    private ClientFactory(){}
    NioEventLoopGroup clientWorker;
    private static final ClientFactory factory;
    static {
        factory = new ClientFactory();
    }
    public static ClientFactory getFactory(){
        return factory;
    }
    /*yige consumer 可以链接多个 provider, 每一个provide 都有自己啊的pool* k v*/
    ConcurrentHashMap<InetSocketAddress,ClientPool> outboxs = new ConcurrentHashMap<>();

    public synchronized NioSocketChannel getClient(InetSocketAddress address){
        ClientPool clientPool = outboxs.get(address);
        if(clientPool == null){
            outboxs.put(address,new ClientPool(poolsize));
            clientPool = outboxs.get(address);

        }
        int i = rand.nextInt(poolsize);
        if(clientPool.clients[i] != null && clientPool.clients[i].isActive()){
            return clientPool.clients[i];
        }
        synchronized (clientPool.lock[i]){
            return clientPool.clients[i] = create(address);
        }



    }
    private NioSocketChannel create(InetSocketAddress address){
        //基于netty的客户端创建方式;
        clientWorker = new NioEventLoopGroup(1);
        Bootstrap bs = new Bootstrap();
        ChannelFuture connect = bs.group(clientWorker)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new ClientResponses());
                    }
                }).connect(address);
        try {
            NioSocketChannel client = (NioSocketChannel) connect.sync().channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class ClientResponses extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;

        if(buf.readableBytes() >= 160){
            byte[] bytes = new byte[160];
            buf.readBytes(bytes);
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            ObjectInputStream oin = new ObjectInputStream(in);
            MyHeader header = (MyHeader)oin.readObject();
            System.out.println("client response @ id : " +header.getRequestID());
            //Todo

            ResponeHandler.runCallBack(header.requestID);

           /* if (buf.readableBytes() >= header.getDataLen()){
                byte[] data = new byte[(int)header.getDataLen()];
                buf.readBytes(data);
                ByteArrayInputStream din = new ByteArrayInputStream(data);
                final ObjectInputStream doin = new ObjectInputStream(din);
                MyContent content = (MyContent) doin.readObject();
                System.out.println(content.getName());
            }*/
        }
        super.channelRead(ctx, msg);
    }
}

class ClientPool{

 NioSocketChannel[] clients;

 Object[] lock;

 ClientPool(int size){
     clients = new NioSocketChannel[size];
     lock = new Object[size];
     for (int i = 0; i < size; i++) {
         lock[i] = new Object();
     }
 }
}

class MyContent implements Serializable{
    String name;
    String methodName;
    Class<?>[] parameterTypesl;
    Object[] args;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypesl() {
        return parameterTypesl;
    }

    public void setParameterTypesl(Class<?>[] parameterTypesl) {
        this.parameterTypesl = parameterTypesl;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
class MyHeader implements Serializable{
    //通信协议
//    1.ooxx的值
//    2.uuid
//    3.date_len
    int flag;
    long requestID;
    long dataLen;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public long getRequestID() {
        return requestID;
    }

    public void setRequestID(long requestID) {
        this.requestID = requestID;
    }

    public long getDataLen() {
        return dataLen;
    }

    public void setDataLen(long dataLen) {
        this.dataLen = dataLen;
    }
}

class ResponeHandler{
   static ConcurrentHashMap<Long,Runnable> mappping = new ConcurrentHashMap<>();

    public static void  addCallBack(Long requestId,Runnable cb){
        mappping.putIfAbsent(requestId,cb);
    }
    public static void runCallBack(Long requestId){
        Runnable runnable = mappping.get(requestId);
        runnable.run();
        removeCB(requestId);
    }

    private static void removeCB(Long requestId) {
        mappping.remove(requestId);
    }
}

class ServerRequestHandler extends ChannelInboundHandlerAdapter{

    //provider
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        ByteBuf sendBuf = buf.copy();


        if(buf.readableBytes() >= 160){
            byte[] bytes = new byte[160];
            buf.readBytes(bytes);
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            ObjectInputStream oin = new ObjectInputStream(in);
            MyHeader header = (MyHeader)oin.readObject();
            System.out.println(header.dataLen);
            System.out.println(header.getRequestID());
            //Todo

            ResponeHandler.runCallBack(header.requestID);

            if (buf.readableBytes() >= header.getDataLen()){
                byte[] data = new byte[(int)header.getDataLen()];
                buf.readBytes(data);
                ByteArrayInputStream din = new ByteArrayInputStream(data);
                final ObjectInputStream doin = new ObjectInputStream(din);
                MyContent content = (MyContent) doin.readObject();
                System.out.println(content.getName());
            }
        }
        ChannelFuture channelFuture = ctx.writeAndFlush(sendBuf);
        channelFuture.sync();
    }
}