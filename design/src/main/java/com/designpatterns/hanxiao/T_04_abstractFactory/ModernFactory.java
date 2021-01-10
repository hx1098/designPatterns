package com.designpatterns.hanxiao.T_04_abstractFactory;

/**
 * @author hx
 * @createTime 2021/1/10 21:16
 * @option  具体工厂
 * @description
 */
public class ModernFactory extends  AbstractFactory {

    @Override
    Food createFood() {

        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
