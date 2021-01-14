package com.designpatterns.hanxiao.T_05_Facade;

/**
 * @author hx
 * @createTime 2021/1/14 9:38
 * @option  Circle 圆形
 * @description  创建实现接口的实体类
 */
public class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Circle  : draw" );
    }
}
