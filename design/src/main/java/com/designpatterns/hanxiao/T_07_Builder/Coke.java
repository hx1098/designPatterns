package com.designpatterns.hanxiao.T_07_Builder;

/**
 * @author hx
 * @createTime 2021/1/12 13:28
 * @option  创建扩展了   ColdDrink 的实体类。
 * @description
 */
public class Coke extends ColdDrink{

    @Override
    public String name() {
        return "可口可乐.....";
    }

    @Override
    public float price() {
        return 30F;
    }
}
