package com.designpatterns.hanxiao.T_07_Builder;

/**
 * @author hx
 * @createTime 2021/1/12 13:38
 * @option 创建一个MealBuilder 对象,实际的builderler负责创建Meal对象
 * @description
 */
public class MealBuilder {
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }


}
