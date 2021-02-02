package com.designpatterns.hanxiao.T_16_Command;

import com.sun.corba.se.pept.broker.Broker;

import javax.swing.border.Border;

/**
 * @author hx
 * @createTime 2021/1/28 13:59
 * @option  命令模式
 * @description
 */
public class main {
    public static void main(String[] args) {


        Stock abcStock = new Stock();

        BuyStock buyStock = new BuyStock(abcStock);
        SellStock sellStock = new SellStock(abcStock);

        Borker borker = new Borker();
        borker.takeOrder(buyStock);
        borker.takeOrder(sellStock);

        borker.placeOrders();
    }

}
