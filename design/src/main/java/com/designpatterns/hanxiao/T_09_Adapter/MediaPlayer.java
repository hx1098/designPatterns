package com.designpatterns.hanxiao.T_09_Adapter;

import javax.xml.crypto.KeySelector;

/**
 * @author hx
 * @createTime 2021/1/12 15:06
 * @option 适配器模式
 * @description  媒体播放器
 */
public interface MediaPlayer {

    /**
     * 播放
     * @param audioType
     * @param fileName
     */
    public void play(String audioType,String fileName);
}
