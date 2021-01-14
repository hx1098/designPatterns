package com.designpatterns.hanxiao.T_06_Decorator;

/**
 * @author hx
 * @createTime 2021/1/13 17:02
 * @option  ShapeDecorator 类的实体装饰类
 * @description
 */
public class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decorateShape) {
        super(decorateShape);
    }


    @Override
    public void draw() {
        decorateShape.draw();
        setRedBorder(decorateShape);
    }

    private void setRedBorder(Shape decorateShape) {
        System.out.println("Border clolor : Red");
    }

}
