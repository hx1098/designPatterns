package com.designpatterns.hanxiao.T_01_singleton;

/**
 * @author hx
 * @createTime 2021/1/7 9:19
 * @option  饿汉式
 * @description  跟Mgr01 是一样的
 */
public class Mgr02 {

    static {
        INSTANCE = new Mgr02();
    }
    private static final Mgr02 INSTANCE;

    public static Mgr02 getInstance(){
        return  INSTANCE;
    }

    public static void main(String[] args) {
        Mgr02 mgr01 = Mgr02.getInstance();
        Mgr02 mgr011 = Mgr02.getInstance();
        System.out.println(mgr01 == mgr011);
    }

}
