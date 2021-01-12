package com.designpatterns.hanxiao.T_07_Builder;

/**
 * @author hx
 * @createTime 2021/1/12 10:36
 * @option 食物条目的接口
 * @description
 */
public interface Item {

    /**
     * 食物名称
     * @return
     */
    public String name();

    /**
     * 包装
     * @return
     */
    public Packing packing();

    /**
     * 价格
     * @return
     */
    public float price();
}
