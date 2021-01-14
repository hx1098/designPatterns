package com.designpatterns.hanxiao.T_06_Decorator;

/**
 * @author hx
 * @createTime 2021/1/13 16:31
 * @option 装饰者模式
 * @description
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape : Rectangle");
    }
}
