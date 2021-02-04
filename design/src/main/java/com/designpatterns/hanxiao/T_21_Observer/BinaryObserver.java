package com.designpatterns.hanxiao.T_21_Observer;

/**
 * @author hx
 * @createTime 2021/2/4 10:00
 * @option 观察者模式 -03
 * @description 创建实体观察者类
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "+ Integer.toBinaryString( subject.getState() ) );
    }
}
