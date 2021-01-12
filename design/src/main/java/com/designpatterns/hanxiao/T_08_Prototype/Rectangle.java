package com.designpatterns.hanxiao.T_08_Prototype;

/**
 * @author hx
 * @createTime 2021/1/12 14:09
 * @option  创建一个拓展 Shape 的类,  Rectangle(长方形)
 * @description
 */
public class Rectangle extends Shape{

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println(" inside Rectangle :: draw() method");
    }
}
