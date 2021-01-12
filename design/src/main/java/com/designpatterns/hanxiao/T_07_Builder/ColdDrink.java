package com.designpatterns.hanxiao.T_07_Builder;

/**
 * @author hx
 * @createTime 2021/1/12 10:52
 * @option  冷饮包装的默认实现
 * @description  实现item接口
 */
public abstract class ColdDrink  implements Item{

    @Override
    public Packing packing() {
        return new Bottle();
    }


    @Override
    public abstract float price();
}
