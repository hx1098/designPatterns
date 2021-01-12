package com.designpatterns.hanxiao.T_10_Bridge;

/**
 * @author hx
 * @createTime 2021/1/12 16:55
 * @option 桥接模式
 * @description  GreenCircle 实现 DrawAPI 接口
 */
public class GreenCircle implements DrawAPI{

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius +", x: " +x+", "+ y +"]");
    }
}
