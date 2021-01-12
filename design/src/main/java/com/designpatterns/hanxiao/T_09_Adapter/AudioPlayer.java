package com.designpatterns.hanxiao.T_09_Adapter;

/**
 * @author hx
 * @createTime 2021/1/12 15:27
 * @option 适配器模式
 * @description 创建实现 MeditPlayer 的实体类
 */
public class AudioPlayer implements MediaPlayer{

    MediaAdapter adapter;


    @Override
    public void play(String audioType, String fileName) {

        //假设 mp3音乐文件内置支持
        if (audioType.equalsIgnoreCase("mp3")){
            System.out.println("Player mp3 file Name = " + fileName);
        }
        else if (audioType.equalsIgnoreCase("vcl") || audioType.equalsIgnoreCase("mp4")){
            adapter = new MediaAdapter(audioType);
            adapter.play(audioType,fileName);
        }
        else {
            System.out.println("Invalid media. \"+\n" +
                    "            audioType + \" format not supported");
        }
    }
}
