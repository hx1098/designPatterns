package com.designpatterns.hanxiao.T_09_Adapter;

/**
 * @author hx
 * @createTime 2021/1/12 15:13
 * @option 适配器模式
 * @description 创建实现高级播放器的实体类
 */
public class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        //nothing to do;
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }
}
