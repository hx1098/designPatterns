package com.designpatterns.hanxiao.T_08_Prototype;

/**
 * @author hx
 * @createTime 2021/1/12 14:34
 * @option
 * @description
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape shape = ShapeCache.getShape("1");
        System.out.println("Shape: " + shape.getType());

        Shape shape2 = ShapeCache.getShape("2");
        System.out.println("Shape: " + shape2.getType());

        Shape shape3 = ShapeCache.getShape("3");
        System.out.println("Shape: " + shape3.getType());



    }
}
