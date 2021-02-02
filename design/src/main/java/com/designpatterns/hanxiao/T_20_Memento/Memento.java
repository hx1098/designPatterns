package com.designpatterns.hanxiao.T_20_Memento;

/**
 * @author hx
 * @createTime 2021/2/2 15:17
 * @option 备忘录模式
 * @description
 */
public class Memento {

    private String state;

    public Memento(String state){
        this.state = state;
    }
    
    public String getState(){
        return  state;
    }


}
