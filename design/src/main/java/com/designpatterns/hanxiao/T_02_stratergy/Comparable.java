package com.designpatterns.hanxiao.T_02_stratergy;

/**
 * @author hx
 * @createTime 2021/1/6 23:32
 * @option  策略模式
 * @description  <T> 指定自己的泛型, 谁要使用的时候就直接指定是什么类型的.
 */
public interface Comparable<T> {

    int compareTo(T o);
}
