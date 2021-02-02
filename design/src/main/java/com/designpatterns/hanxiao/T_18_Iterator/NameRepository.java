package com.designpatterns.hanxiao.T_18_Iterator;

/**
 * @author hx
 * @createTime 2021/2/2 14:54
 * @option 迭代器模式
 * @description 创建实现container接口的实体类,该类实现了iterator 接口的内部类,NameIterator
 */
public class NameRepository implements Container{
    public String[] names = {"Robert","John","Jolie","Lora"};


    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;
        @Override
        public boolean hashNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hashNext()){
               return names[index++];
            }
            return null;
        }
    }
}
