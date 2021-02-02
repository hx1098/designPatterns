package com.designpatterns.hanxiao.T_19_Mediator;

import java.util.Date;

/**
 * @author hx
 * @createTime 2021/2/2 15:07
 * @option  中介模式
 * @description
 */
public class ChatRoom {

    public static void showMessage(User user,String message){
        System.out.println(new Date().toString() +  " [" + user.getName() +"] : " + message);
    }
}
