package com.designpatterns.hanxiao.T_20_Memento;

/**
 * @author hx
 * @createTime 2021/2/2 15:25
 * @option 备忘录模式
 * @description
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento(){
        return  new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}
