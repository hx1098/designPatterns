package com.singleton;

/**
 * @author hx
 * @createTime 2021/1/7 10:59
 * @option  懒汉式
 * @description
 *      虽然也达到了按需初始化的目的, 但是代理了线程不安全的问题,
 *  *  可以通过sychronized 来解决问题,但是效率会有所下降.
 *
 */
public class Mgr05 {
        private static Mgr05 instance = null;

        private Mgr05(){}

        public static Mgr05 getInstance(){
            if(instance == null){
                //这种方式: 使用sychronized来缩小锁范围, 其实是不行的.
                synchronized (Mgr05.class){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Mgr05();
                }
            }
            return instance;
        }

    public static void main(String[] args) {
        for (int i = 0; i <100; i++) {
            new Thread(()->{
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
    }


}
