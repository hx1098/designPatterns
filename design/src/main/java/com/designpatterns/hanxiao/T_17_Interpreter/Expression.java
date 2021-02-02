package com.designpatterns.hanxiao.T_17_Interpreter;

/**
 * @author hx
 * @createTime 2021/2/2 14:00
 * @option 解释器模式
 * @description
 */
public interface Expression {
     boolean interpret(String context);
}
