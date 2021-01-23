package com.designpatterns.hanxiao.T_15_ChainOfResponsibility;

/**
 * @author hx
 * @createTime 2021/1/20 16:51
 * @option 责任链模式
 * @description
 */
public class ErrorLog extends AbstractLogger {


    public ErrorLog(int levle){
        this.level = levle;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standed Error: logger " + message);
    }
}
