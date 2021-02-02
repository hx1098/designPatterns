package com.designpatterns.hanxiao.T_16_Command;

/**
 * @author hx
 * @createTime 2021/1/28 14:30
 * @option 命令模式
 * @description
 */
public class Stock {

    private String name = "ABC";
    private int quantity = 10;

    public void buy(){
        System.out.println("Stock ["+ name +"Quantity" + quantity+"]" +"bought");

    }

    public void sell(){
        System.out.println("Stock ["+ name +"Quantity" + quantity+"]" +"sold");
    }
}
