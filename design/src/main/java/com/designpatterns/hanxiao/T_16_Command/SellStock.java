package com.designpatterns.hanxiao.T_16_Command;

/**
 * @author hx
 * @createTime 2021/1/28 15:09
 * @option 命令模式
 * @description
 */
public class SellStock implements Order {

    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
