package com.designpatterns.hanxiao.T_17_Interpreter;

/**
 * @author hx
 * @createTime 2021/2/2 14:26
 * @option 解释器模式
 * @description 使用expression 来创建规则,并解析他们
 */
public class InterpreterPatternDemo  {

    //规则：Robert 和 John 是男性
    public static  Expression getMaleExpression(){
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new ORExprression(robert,john);

    }

    //规则: Julie 是一个已婚的女性
    public static Expression getMarriedWomanExpression(){
        Expression julie = new TerminalExpression("Julie");
        Expression married  = new TerminalExpression("Married ");

        return new AndExpression(julie,married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women? "
                + isMarriedWoman.interpret("Married Julie"));

    }





}
