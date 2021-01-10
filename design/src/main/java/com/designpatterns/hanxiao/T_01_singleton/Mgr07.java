package com.designpatterns.hanxiao.T_01_singleton;

/**
 * @author hx
 * @createTime 2021/1/7 14:50
 * @option  静态内部类的方式
 * @description
 *   外部类被加载时不需要加载内部类, 第一次调用的时候才回去加载到虚拟机,
 *   确保了线程安全,也保证了单例的唯一性,
 *
 */
public class Mgr07 {

    private Mgr07(){}

    private static class Mgr07Holder{
        private final static Mgr07 instance = new Mgr07();
    }

    public static Mgr07 getInstance(){
        return Mgr07Holder.instance;
    }

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(Mgr07Holder.instance.hashCode());
            }
        }).start();
    }

}
