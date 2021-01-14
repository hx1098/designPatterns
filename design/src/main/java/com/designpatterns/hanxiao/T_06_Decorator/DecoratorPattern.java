package com.designpatterns.hanxiao.T_06_Decorator;

/**
 * @author hx
 * @createTime 2021/1/13 17:10
 * @option
 * @description
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle width normal border");
        circle.draw();

        System.out.println("redCircle width normal border");
        redCircle.draw();

        System.out.println("RectCircle width normal border");
        redRectangle.draw();


    }

}
