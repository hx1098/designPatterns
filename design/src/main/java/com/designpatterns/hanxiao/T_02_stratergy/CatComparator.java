package com.designpatterns.hanxiao.T_02_stratergy;

/**
 * @author hx
 * @createTime 2021/1/10 18:43
 * @option
 * @description
 */
public class CatComparator implements Comparator<Cat>{

    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.weight < o2.weight) return -1;
        else if  (o1.weight < o2.weight) return 1;
        else return 0;
    }
}
