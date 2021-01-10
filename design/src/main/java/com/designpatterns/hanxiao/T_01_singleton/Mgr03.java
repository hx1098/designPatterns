package com.designpatterns.hanxiao.T_01_singleton;

/**
 * @author hx
 * @createTime 2021/1/7 9:53
 * @option   懒汉式
 * @description  可以看到,这种懒汉式, 虽然达到了按需来进行访问,不能保证多线程的情况下来访问,
 */
public class Mgr03 {

    private static Mgr03 instance = null;
    private Mgr03(){};
    public static Mgr03 getInstance(){
        if(instance == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Mgr03();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i< 100;i++){
            new Thread(()->{
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }



}
