package com.designpatterns.hanxiao.T_04_abstractFactory;

/**
 * @author hx
 * @createTime 2021/1/10 21:18
 * @option
 * @description
 */
public class MagicFactory extends AbstractFactory {


    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
