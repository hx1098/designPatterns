package com.designpatterns.hanxiao.T_19_Mediator;

/**
 * @author hx
 * @createTime 2021/2/2 15:09
 * @option 中介模式
 * @description
 */
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }
    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
