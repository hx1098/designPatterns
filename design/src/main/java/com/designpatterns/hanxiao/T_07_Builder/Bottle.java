package com.designpatterns.hanxiao.T_07_Builder;

/**
 * @author hx
 * @createTime 2021/1/12 10:42
 * @option  瓶子包装, 实现Packing
 * @description
 */
public class Bottle implements Packing{

    /**瓶子包装, 实现Packing*/
    public Bottle() {
    }

    @Override
    public String pack() {
        return "Bottle使用瓶子装.......";
    }
}
