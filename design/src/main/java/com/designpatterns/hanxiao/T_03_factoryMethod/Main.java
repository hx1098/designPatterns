package com.designpatterns.hanxiao.T_03_factoryMethod;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * @author hx
 * @createTime 2021/1/10 19:31
 * @option 工厂
 * @description
 */
public class Main {
    public static void main(String[] args) {
       /* Car c = new Car();
        c.go();
*/
        Moveable m = new Car();

        /*直接创建car就行*/
        Moveable m2 = new CarFacroty().createCar();


    }

}
