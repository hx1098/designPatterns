package com.designpatterns.hanxiao.T_05_Facade;

/**
 * @author hx
 * @createTime 2021/1/14 9:46
 * @option  外观类
 * @description
 */
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
        this.square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawRectangle(){
        rectangle.draw();
    }

    public void drawSquare(){
        square.draw();
    }




}
