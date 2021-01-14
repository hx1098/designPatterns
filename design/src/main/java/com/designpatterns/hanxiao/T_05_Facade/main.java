package com.designpatterns.hanxiao.T_05_Facade;

/**
 * @author hx
 * @createTime 2021/1/14 9:49
 * @option
 * @description
 */
public class main {
    public static void main(String[] args) {

        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }

}
