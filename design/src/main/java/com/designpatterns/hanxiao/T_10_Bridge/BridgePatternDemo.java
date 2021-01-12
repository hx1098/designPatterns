package com.designpatterns.hanxiao.T_10_Bridge;

/**
 * @author hx
 * @createTime 2021/1/12 17:11
 * @option
 * @description
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape  redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape  greenCircle = new Circle(100,100,10,new GreenCircle());

        redCircle.draw();
        greenCircle.draw();

    }

}
