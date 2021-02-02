package com.designpatterns.hanxiao.T_19_Mediator;

/**
 * @author hx
 * @createTime 2021/2/2 15:05
 * @option  中介模式
 * @description  使用User来显示他们之间的通讯
 */
public class main {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi John");
        john.sendMessage("Hi,Robert");
    }
}
