package com.designpatterns.hanxiao.stratergy;

/**
 * @author hx
 * @createTime 2021/1/6 23:36
 * @option
 * @description
 */
public class Dog  implements  Comparable<Dog>{

    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Dog g) {
        if(this.food < g.food){
            return -1;
        }else if(this.food > g.food) {
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
