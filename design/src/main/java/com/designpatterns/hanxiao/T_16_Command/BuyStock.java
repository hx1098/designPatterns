package com.designpatterns.hanxiao.T_16_Command;

/**
 * @author hx
 * @createTime 2021/1/28 14:34
 * @option
 * @description 命令模式
 */
public class BuyStock implements Order {

    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}