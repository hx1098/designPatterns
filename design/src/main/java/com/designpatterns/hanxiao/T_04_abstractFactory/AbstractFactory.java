package com.designpatterns.hanxiao.T_04_abstractFactory;

/**
 * @author hx
 * @createTime 2021/1/10 21:05
 * @option  一个抽象的工厂, 三个抽象的产品
 * @description
 */
public abstract class AbstractFactory {

    abstract Food createFood();

    abstract Vehicle createVehicle();

    abstract Weapon createWeapon();


}
