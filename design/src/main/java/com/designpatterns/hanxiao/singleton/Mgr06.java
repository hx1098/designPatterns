package com.designpatterns.hanxiao.singleton;

/**
 * @author hx
 * @createTime 2021/1/7 13:24
 * @option  懒汉式
 * @description  虽然也达到了按需初始化的目的,但是却带来了线程不安全的问题.
 *                可以通过sychronized来解决问题,但是也带来了效率下降
 */
public class Mgr06 {
    private static volatile Mgr06 instance = null;

    public Mgr06(){}

    public static Mgr06 getInstance(){
        //双重检测模式
         if (instance == null){
             synchronized (Mgr06.class){
                 if (instance == null){
                     try {
                         Thread.sleep(1);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     instance = new Mgr06();
                 }
             }
         }
         return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}
