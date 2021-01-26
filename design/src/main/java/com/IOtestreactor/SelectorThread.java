package com.IOtestreactor;

import org.apache.logging.log4j.spi.StandardLevel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.security.Key;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author hx
 * @createTime 2021/1/23 10:06
 * @option
 * @description 多路复用器, 每一个线程对应一个selector,多线程情况系,该主机,改程序的并发客户端被分配到多个selector上
 *  //注意: 每个客户端只绑定到其中一个selector上
 *  //其实:不忽悠交互问题
 */
public class SelectorThread implements Runnable{


    Selector selector = null;
    LinkedBlockingQueue<Channel> lbq = new LinkedBlockingQueue<>();

    SelectorThread(){
        try {
            selector = Selector.open();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //loop
        while (true){
            try {
                //1. select() 阻塞
                System.out.println(Thread.currentThread().getName() +  " : before select....." + selector.keys().size());
                int nums = selector.select();
//                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() +  " : after select....." + selector.keys().size());

                //2. selectkeys
                if(nums > 0){
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iter = keys.iterator();
                    //线性的处理过程
                    while (iter.hasNext()){
                        SelectionKey next = iter.next();
                        iter.remove();
                        if(next.isAcceptable()){//复杂,接收客户端的过程,
                            acceptHandler(next);

                        }else if (next.isReadable()){
                            readHandler(next);
                        }else if (next.isWritable()){

                        }
                    }

                }
                //3. 处理一些tasks
                if (!lbq.isEmpty()){
                    Channel c =  lbq.take();
                    if (c instanceof  ServerSocketChannel){

                    }else if (c instanceof SocketChannel){

                    }

                }



            } catch (IOException e) {
                e.printStackTrace();
            } /*catch (InterruptedException e) {
                e.printStackTrace();
            }*/ catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private void readHandler(SelectionKey next) {
        ByteBuffer buffer = (ByteBuffer) next.attachment();
        SocketChannel client = (SocketChannel) next.channel();
        buffer.clear();
        while (true){
            try {
                int nums = client.read(buffer);
                if(nums>0){
                    buffer.flip();//将读取到的内容翻转,然后直接写出
                    while (buffer.hasRemaining()){
                        client.write(buffer);
                    }
                    buffer.clear();
                }else if (nums == 0){
                    break;
                }else if (nums < 0){
                    //客户端断开了
                    System.out.println( client.getRemoteAddress() + "closed ........" );
                    next.cancel();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private void acceptHandler(SelectionKey next) {
        ServerSocketChannel server = (ServerSocketChannel) next.channel();
        try {
            SocketChannel client = server.accept();
            client.configureBlocking(false);

            //choose a selecotr and register!!

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
