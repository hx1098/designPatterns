package com.designpatterns.hanxiao.T_13_Flyweight;

import java.util.HashMap;

/**
 * @author hx
 * @createTime 2021/1/14 14:27
 * @option 创建一个工厂,生成一个基于给定信息的实体类对象.
 * @description
 */
public class ShapeFactory {

    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {

        Circle shape = (Circle) circleMap.get(color);
        if (shape == null) {
            shape = new Circle(color);
            circleMap.put(color, shape);
            System.out.println("creating circle of color : " + shape);
        }
        return shape;
    }

}