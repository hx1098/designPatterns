package com.designpatterns.hanxiao.T_05_Facade;

/**
 * @author hx
 * @createTime 2021/1/14 9:38
 * @option  Square 正方形
 * @description  创建实现接口的实体类
 */
public class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square  : draw" );
    }
}
