package com.designpatterns.hanxiao.T_21_Observer;

/**
 * @author hx
 * @createTime 2021/2/4 9:56
 * @option 观察者模式 01
 * @description
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();

}
