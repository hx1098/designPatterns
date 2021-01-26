package com.IOtestreactor;

/**
 * @author hx
 * @createTime 2021/1/23 10:05
 * @option
 * @description
 * 这里不做关于IO和业务的事情
 */
public class MainThread {
    public static void main(String[] args) {


        //1创建iothread (第一个或者多个)
        SelectorThreadGroup stg = new SelectorThreadGroup(1);
        //混杂模式,只有一个线程负责accept,每一个都会分配clent进行读写
//        SelectorThreadGroup stg = new SelectorThreadGroup(3);
        stg.bind(9999);


        //2.把监听的"server" 注册到某一个 selector上

    }

}
