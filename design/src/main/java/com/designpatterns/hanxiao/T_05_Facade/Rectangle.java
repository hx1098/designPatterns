package com.designpatterns.hanxiao.T_05_Facade;

/**
 * @author hx
 * @createTime 2021/1/14 9:38
 * @option  Rectangle 长方形
 * @description  创建实现接口的实体类
 */
public class Rectangle  implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle  : draw" );
    }
}
