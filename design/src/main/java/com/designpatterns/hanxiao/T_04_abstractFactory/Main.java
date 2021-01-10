package com.designpatterns.hanxiao.T_04_abstractFactory;


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
       AK47 ak47 = new AK47();
       ak47.shot();
       Bread b = new Bread();
       b.printName();*/
        /**这里直接实例化工厂,获取工厂里的东西*/
       AbstractFactory factory = new MagicFactory();
        Food food = factory.createFood();
        food.printName();
        Vehicle vehicle = factory.createVehicle();
        vehicle.go();
        Weapon weapon = factory.createWeapon();
        weapon.shoot();

    }

}
