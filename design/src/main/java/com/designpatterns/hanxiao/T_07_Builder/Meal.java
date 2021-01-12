package com.designpatterns.hanxiao.T_07_Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hx
 * @createTime 2021/1/12 13:31
 * @option Meal
 * @description 创建一个 Meal 类，带有上面定义的 Item的对象
 */
public class Meal {
    private List<Item> items  = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    /**
     * 一餐花多少钱
     * @return
     */
    public float getCost(){
        float cost = 0.00f;
        for (Item item : items) {
            cost +=item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
            
        }
    }


}
