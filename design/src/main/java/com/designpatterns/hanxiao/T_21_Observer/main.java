package com.designpatterns.hanxiao.T_21_Observer;

/**
 * @author hx
 * @createTime 2021/2/4 10:32
 * @option 使用 Subject 和实体观察者对象。 (这个貌似不太对.)
 * @description
 */
public class main {

    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new BinaryObserver(subject);
        new OctalObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);

    }
}
