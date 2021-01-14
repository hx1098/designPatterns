package com.designpatterns.hanxiao.T_06_Decorator;

/**
 * @author hx
 * @createTime 2021/1/13 16:35
 * @option
 * @description
 */
public class ShapeDecorator  implements  Shape{

    protected  Shape decorateShape;

    public ShapeDecorator(Shape decorateShape) {
        this.decorateShape = decorateShape;
    }

    @Override
    public void draw() {
        decorateShape.draw();
    }
}
