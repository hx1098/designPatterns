package com.designpatterns.hanxiao.T_02_stratergy;

import java.util.Arrays;

/**
 * @author hx
 * @createTime 2021/1/6 21:49
 * @option  策略模式
 * @description
 */
public class Main {

    public static void main(String[] args) {
//        int[] arr = {8,4,9,0,2,6};
        Cat[] a = {new Cat(5,5),new Cat(3,3),new Cat(2, 2)};
//        Dog[] a = {new Dog(1),new Dog(3),new Dog(2)};
//
//        Sorter<Dog>  sorter = new Sorter<>();
        Sorter<Cat>  sorter = new Sorter<>();
//        sorter.sort(a,new CatComparator());
        sorter.sort(a,(o1,o2)->{
            if (o1.weight > o2.weight) return -1;
            else if(o1.weight < o2.weight) return 1;
            else return 0;
        });
        System.out.println(Arrays.toString(a));
    }

}
