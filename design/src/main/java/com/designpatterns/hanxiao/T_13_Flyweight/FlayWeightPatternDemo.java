package com.designpatterns.hanxiao.T_13_Flyweight;

import com.designpatterns.hanxiao.T_06_Decorator.ShapeDecorator;

/**
 * @author hx
 * @createTime 2021/1/14 16:08
 * @option
 * @description
 */
public class FlayWeightPatternDemo {

    private static final String colors[] = {"Red","Green","Blue","White","Black"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            ShapeFactory.getCircle(getRandomColor());
        }
    }

    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }

    private static int getRandomX(){
        return (int)(Math.random()*100);
    }

    private static int getRandomY(){
        return (int)(Math.random()*100);
    }
}
