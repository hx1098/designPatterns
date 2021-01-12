package com.designpatterns.hanxiao.T_09_Adapter;

/**
 * @author hx
 * @createTime 2021/1/12 15:06
 * @option 适配器模式
 * @description  适配器   实现MediaPlayer
 */
public class MediaAdapter implements MediaPlayer{

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vcl")){
                advancedMediaPlayer = new VclPlayer();
        }
        else if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vcl")){
            advancedMediaPlayer.playVlc(fileName);
        }
        else if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
