package com.designpatterns.hanxiao.T_18_Iterator;

/**
 * @author hx
 * @createTime 2021/2/2 14:43
 * @option 迭代器模式
 * @description 使用NmaeRePository来获取迭代器,并打印名字
 */
public class main {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for (Iterator iter = nameRepository.getIterator();iter.hashNext();){

            String name = (String) iter.next();
            System.out.println(" Nmae = " + name);
        }
    }
}
