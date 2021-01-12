package com.designpatterns.hanxiao.T_09_Adapter;

/**
 * @author hx
 * @createTime 2021/1/12 15:42
 * @option
 * @description
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

//        audioPlayer.play("mp3", "后来.mp3");
        audioPlayer.play("vcl", "fafa");
//        audioPlayer.play("mp4", "好事一桩.mp4");
        audioPlayer.play("avi", "avi");
    }
}
