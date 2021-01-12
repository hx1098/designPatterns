package com.designpatterns.hanxiao.T_09_Adapter;

/**
 * @author hx
 * @createTime 2021/1/12 15:06
 * @option 适配器模式
 * @description  高级媒体播放器
 */
public interface AdvancedMediaPlayer {

    /**
     * Vcl格式
     * @param fileName
     */
    public void playVlc(String fileName);

    /**
     * Mp4格式
     * @param fileName
     */
    public void playMp4(String fileName);
}
