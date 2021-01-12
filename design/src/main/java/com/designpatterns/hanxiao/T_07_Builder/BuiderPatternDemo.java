package com.designpatterns.hanxiao.T_07_Builder;

/**
 * @author hx
 * @createTime 2021/1/12 13:44
 * @option 使用 MealBuider 来演示建造者模式
 * @description
 */
public class BuiderPatternDemo {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("TotalCost: " + vegMeal.getCost());



        Meal nonMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("Non Meal");
        nonMeal.showItems();
        System.out.println("TotalCost: " + nonMeal.getCost());

    }
}
