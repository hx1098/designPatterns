package com.designpatterns.hanxiao.T_14_Proxy;

/**
 * @author hx
 * @createTime 2021/1/14 16:25
 * @option
 * @description
 */
public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void display() {
        if (realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }


}
