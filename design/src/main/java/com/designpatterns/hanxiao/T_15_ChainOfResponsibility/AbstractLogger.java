package com.designpatterns.hanxiao.T_15_ChainOfResponsibility;

/**
 * @author hx
 * @createTime 2021/1/14 16:38
 * @option  责任链模式
 * @description
 */
public abstract class AbstractLogger {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    //责任链下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessge(int level,String message){
        if (this.level < level){
            write(message);
        }
        if (nextLogger != null){
            nextLogger.logMessge(level,message);
        }
    }
    abstract protected void write(String message);
}
