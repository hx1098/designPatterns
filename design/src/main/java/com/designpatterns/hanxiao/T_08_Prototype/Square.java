package com.designpatterns.hanxiao.T_08_Prototype;

/**
 * @author hx
 * @createTime 2021/1/12 14:09
 * @option  创建一个拓展 Shape 的类,  Square(正方形)
 * @description
 */
public class Square extends Shape{

    public Square(){
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println(" inside Square :: draw() method");
    }
}
