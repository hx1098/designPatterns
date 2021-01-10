package com.designpatterns.hanxiao.T_03_factoryMethod;

/**
 * @author hx
 * @createTime 2021/1/10 19:50
 * @option   工厂模式
 * @description
 */
public class CarFacroty {
    public Car createCar(){
        System.out.println("a car created");
        return new Car();
    }

}
