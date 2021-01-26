package com.IOtestreactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hx
 * @createTime 2021/1/23 10:36
 * @option
 * @description
 */
public class SelectorThreadGroup {

    SelectorThread[] sts;
    ServerSocketChannel server = null;
    AtomicInteger xid = new AtomicInteger(0);


    public SelectorThreadGroup(int num) {
        //num 线程数
        sts =  new SelectorThread[num];
        for (int i = 0; i < num; i++) {
            sts[i] = new SelectorThread();
            new Thread(sts[i]).start();
            
        }

    }

    public void bind(int port){
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));


            //注册到哪个selector?
            nestSelector(server);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void nestSelector(Channel c) {
        SelectorThread st = next();
        st.lbq.add(c);//通过队列传递数据
        st.selector.wakeup();//通过打断阻塞,让对应的线程去自己在打断后哦完成注册selector

        //重点 c有可能是 server, 也有可能是client
//        ServerSocketChannel s = (ServerSocketChannel) c;
       /* try {
            s.register(st.selector, SelectionKey.OP_ACCEPT); //呼应上      int nums = selector.select();
            st.selector.wakeup();//功能上是让selector的select方法, 立刻返回,不阻塞
            System.out.println("aaaaaa");
        } catch (ClosedChannelException e) {
            e.printStackTrace();
        }*/


    }

    //无论serversocket 还是socket 都复用这个方法
    private SelectorThread next() {
        int index = xid.incrementAndGet() % sts.length;
        return sts[index];
    }


}
