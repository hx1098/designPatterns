package com.designpatterns.hanxiao.T_20_Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hx
 * @createTime 2021/2/2 15:32
 * @option 备忘录模式.
 * @description
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento){
        mementoList.add(memento);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }

}
