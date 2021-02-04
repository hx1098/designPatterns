package com.designpatterns.hanxiao.T_21_Observer;

/**
 * @author hx
 * @createTime 2021/2/4 10:30
 * @option  观察者模式-04
 * @description  创建实体观察者类
 */
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) );
    }
}
