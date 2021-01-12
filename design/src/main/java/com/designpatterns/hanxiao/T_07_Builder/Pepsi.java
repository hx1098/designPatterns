package com.designpatterns.hanxiao.T_07_Builder;

/**
 * @author hx
 * @createTime 2021/1/12 13:29
 * @option  创建扩展了   ColdDrink 的实体类。
 * @description  百事可乐
 */
public class Pepsi extends ColdDrink{

    @Override
    public String name() {
        return "百事可乐.....";
    }

    @Override
    public float price() {
        return 29.0F;
    }
}
