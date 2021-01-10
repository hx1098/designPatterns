package com.designpatterns.hanxiao.T_01_singleton;

/**
 * @author hx
 * @createTime 2021/1/6 20:44
 * @option 饿汉式
 * @description
 *  类加载到内存后就实例化一个单例, jvm的双亲委派保证了线程安全.
 *  缺点: 不管用到与否,类装载时就实例化
 */
public class Mgr01 {

    private static final Mgr01 instance = new Mgr01();
    private Mgr01(){}
    public static Mgr01 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Mgr01 mgr01 = Mgr01.getInstance();
        Mgr01 mgr011 = Mgr01.getInstance();
        System.out.println(mgr01 == mgr011);
    }

}
