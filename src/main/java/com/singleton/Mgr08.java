package com.singleton;

/**
 * @author hx
 * @createTime 2021/1/7 15:16
 * @option  枚举实现
 * @description: 不仅可以解决线程同步,还可以防止反序列化
 *
 */
public enum  Mgr08 {

    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();
        }
    }


}
