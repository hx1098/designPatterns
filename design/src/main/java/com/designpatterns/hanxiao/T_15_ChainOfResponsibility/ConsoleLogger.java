package com.designpatterns.hanxiao.T_15_ChainOfResponsibility;

/**
 * @author hx
 * @createTime 2021/1/20 16:49
 * @option 责任链模式
 * @description
 */
public class ConsoleLogger extends AbstractLogger{


    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standed Console: logger " + message);
    }
}
