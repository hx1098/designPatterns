package com.designpatterns.hanxiao.T_03_factoryMethod;

/**
 * @author hx
 * @createTime 2021/1/10 19:43
 * @option   简单工厂,
 * @description  可扩展不好
 */
public class SimpleVehicleFactory {

    public Car createCar(){

        //
        return new Car();
    }

    public Broom createBroom(){

        return new Broom();
    }



}
