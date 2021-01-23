package com.designpatterns.hanxiao.T_15_ChainOfResponsibility;

import sun.rmi.runtime.Log;

import java.awt.print.PrinterAbortException;
import java.util.logging.Logger;

/**
 * @author hx
 * @createTime 2021/1/20 16:55
 * @option 责任链模式
 * @description 创建不同类型的记录器。赋予它们不同的错误级别，并在每个记录器中设置下一个记录器。每个记录器中的下一个记录器代表的是链的一部分
 */
public class main {

    private  static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLog = new ErrorLog(AbstractLogger.ERROR);
        AbstractLogger fileLog = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLog  = new ConsoleLogger( AbstractLogger.INFO);

        errorLog.setNextLogger(fileLog);
        fileLog.setNextLogger(consoleLog);

        return errorLog;

    }


    public static void main(String[] args) {
        AbstractLogger lgggerChain = getChainOfLoggers();
        lgggerChain.logMessge(AbstractLogger.INFO,"THis is an information");

        lgggerChain.logMessge(AbstractLogger.DEBUG,"this is debug message");

        lgggerChain.logMessge(AbstractLogger.ERROR,"this is errot message");

    }

}
