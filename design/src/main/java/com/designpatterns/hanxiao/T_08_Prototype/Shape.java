package com.designpatterns.hanxiao.T_08_Prototype;

/**
 * @author hx
 * @createTime 2021/1/12 14:00
 * @option 先创建一个原型抽象类, 实现Cloneable类
 * @description
 */
public abstract class Shape implements Cloneable{

    private String id;
    protected String type;

    abstract void draw();

    @Override
    public Object clone(){
        Object obj = null;
        try {
            obj =  super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
