package com.designpatterns.hanxiao.T_07_Builder;

/**
 * @author hx
 * @createTime 2021/1/12 10:55
 * @option  创建扩展了 Burger 的实体类
 * @description  进一步实现name, price
 */
public class VegBurger extends Burger{

    @Override
    public String name() {
         return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0F;
    }
}
