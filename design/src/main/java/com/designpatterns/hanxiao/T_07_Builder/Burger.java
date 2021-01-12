package com.designpatterns.hanxiao.T_07_Builder;

/**
 * @author hx
 * @createTime 2021/1/12 10:46
 * @option  汉堡的保障
 * @description  创建实现item(食物品类) 的抽象类,
 */
public abstract  class Burger implements Item{


    /**
     * 打包
     * @return
     */
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    /**
     * 价格
     * @return
     */
    @Override
    public abstract float price();
}
