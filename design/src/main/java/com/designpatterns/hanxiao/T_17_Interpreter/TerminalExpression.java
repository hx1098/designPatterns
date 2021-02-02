package com.designpatterns.hanxiao.T_17_Interpreter;

import java.net.ContentHandler;

/**
 * @author hx
 * @createTime 2021/2/2 14:12
 * @option 解释器模式
 * @description
 */
public class TerminalExpression implements Expression {


    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)){
            return  true;
        }
        return false;
    }
}
