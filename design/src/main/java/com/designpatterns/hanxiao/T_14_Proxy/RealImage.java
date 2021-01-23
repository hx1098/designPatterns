package com.designpatterns.hanxiao.T_14_Proxy;

/**
 * @author hx
 * @createTime 2021/1/14 16:20
 * @option  image 实现类
 * @description
 */
public class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
