package com.designpatterns.hanxiao.T_10_Bridge;

/**
 * @author hx
 * @createTime 2021/1/12 16:56
 * @option  桥接模式
 * @description 使用DrawApi 创建抽象类
 */
public abstract class Shape {

    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }

    public abstract void draw();

}
