package com.designpatterns.hanxiao.T_14_Proxy;

/**
 * @author hx
 * @createTime 2021/1/14 16:17
 * @option  代理模式
 * @description
 */
public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");

        image.display();
        System.out.println("    222");
        image.display();
    }
}
