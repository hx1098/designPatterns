package com.designpatterns.hanxiao.T_10_Bridge;

/**
 * @author hx
 * @createTime 2021/1/12 17:06
 * @option  桥接模式
 * @description 实现shape
 */
public class Circle extends Shape{

    private int x,y,radius;

    protected Circle(int x,int y,int radius,DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}
