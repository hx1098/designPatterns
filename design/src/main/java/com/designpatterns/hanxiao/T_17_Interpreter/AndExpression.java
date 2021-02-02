package com.designpatterns.hanxiao.T_17_Interpreter;

/**
 * @author hx
 * @createTime 2021/2/2 14:23
 * @option 解释器模式
 * @description
 */
public class AndExpression implements Expression {


    private Expression exp1 = null;
    private Expression exp2 = null;

    public AndExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public boolean interpret(String context) {
        return exp1.interpret(context) && exp2.interpret(context);
    }
}
