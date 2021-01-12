package com.designpatterns.hanxiao.T_07_Builder;

/**
 * @author hx
 * @createTime 2021/1/12 10:42
 * @option  包装纸包装, 实现Packing
 * @description
 */
public class Wrapper implements Packing{


    /**包装纸包装, 实现Packing*/
    public Wrapper(){};

    @Override
    public String pack() {
        return "Wrapper使用包装纸包装.......";
    }
}
