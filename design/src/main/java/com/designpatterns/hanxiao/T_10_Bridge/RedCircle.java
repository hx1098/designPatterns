package com.designpatterns.hanxiao.T_10_Bridge;

/**
 * @author hx
 * @createTime 2021/1/12 16:48
 * @option 桥接模式
 * @description  RedCircle 实现 DrawAPI 接口
 */
public class RedCircle implements DrawAPI{

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "+ radius +", x: " +x+", "+ y +"]" );
    }
}
