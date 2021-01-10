package com.designpatterns.hanxiao.T_02_stratergy;

/**
 * @author hx
 * @createTime 2021/1/10 18:43
 * @option
 * @description
 */
public class DogComparator  implements Comparator<Dog>{

    @Override
    public int compare(Dog o1, Dog o2) {
        if (o1.food < o2.food) return -1;
        else if  (o1.food < o2.food) return 1;
        else return 0;
    }
}
