package com.designpatterns.hanxiao.T_10_Bridge;

/**
 * @author hx
 * @createTime 2021/1/12 16:44
 * @option  桥接模式
 * @description 桥接接口
 */
public interface DrawAPI {


    /**
     * 画圆
     * @param radius
     * @param x
     * @param y
     */
    public void drawCircle(int radius,int x,int y);
}
