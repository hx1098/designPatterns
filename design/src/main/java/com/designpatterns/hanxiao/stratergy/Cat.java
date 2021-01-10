package com.designpatterns.hanxiao.stratergy;

/**
 * @author hx
 * @createTime 2021/1/6 23:19
 * @option
 * @description  策略模式
 */
public class Cat implements Comparable<Cat>{

    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Cat c) {

        if(this.weight < c.weight) return -1;
        else if(this.weight > c.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
