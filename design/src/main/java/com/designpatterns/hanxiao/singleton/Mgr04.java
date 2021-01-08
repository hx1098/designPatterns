package com.designpatterns.hanxiao.singleton;

/**
 * @author hx
 * @createTime 2021/1/7 10:52
 * @option 懒汉式
 * @description
 *  虽然也达到了按需初始化的目的,但是代理了线程不安全的问题,
 *  可以通过sychronized 来解决问题,但是效率会有所下降.
 *
 */
public class Mgr04 {

    private static Mgr04 instance;
    private Mgr04(){};
    public static  synchronized Mgr04 getInstance(){
        if (instance == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Mgr04();
        }
        return instance;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }


}
