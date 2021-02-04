package com.designpatterns.hanxiao.T_21_Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hx
 * @createTime 2021/2/4 9:54
 * @option  观察者模式 02
 * @description
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }




}
