package com.designpatterns.hanxiao.T_16_Command;

import com.designpatterns.hanxiao.T_11_Filter.OrCriteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hx
 * @createTime 2021/2/2 13:47
 * @option   创建命令模式调用
 * @description
 */
public class Borker {
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }

    
}
