package com.designpatterns.hanxiao.T_15_ChainOfResponsibility;

import java.io.File;

/**
 * @author hx
 * @createTime 2021/1/20 16:53
 * @option 责任链模式
 * @description
 */
public class FileLogger extends AbstractLogger{

    public FileLogger(int levle){
         this.level = levle;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standed File: logger " + message);
    }
}
