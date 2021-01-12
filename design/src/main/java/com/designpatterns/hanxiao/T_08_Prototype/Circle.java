package com.designpatterns.hanxiao.T_08_Prototype;

/**
 * @author hx
 * @createTime 2021/1/12 14:15
 * @option   创建一个拓展 Shape 的类,  Circle(园形)
 * @description
 */
public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println(" inside Circle :: draw() method");
    }
}
