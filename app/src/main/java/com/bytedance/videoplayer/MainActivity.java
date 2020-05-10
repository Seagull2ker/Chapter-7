package com.bytedance.videoplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private VideoView vv_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        String url = "https://s3.pstatp.com/toutiao/static/img/logo.271e845.png";
        Glide.with(this).load(url).into(imageView);

        vv_video = (VideoView) findViewById(R.id.vv_video); ////获取VideoView的id
        //设置播放的来源
        vv_video.setVideoPath(getResPath(R.raw.bytedance));
        //实例化媒体控制器
        MediaController mediaController=new MediaController(this);
        mediaController.setMediaPlayer(vv_video);
        vv_video.setMediaController(mediaController);
        vv_video.start();

    }
    @org.jetbrains.annotations.NotNull
    private String getResPath(int res) {
        return "android.resource://" + this.getPackageName() + "/" + res;
    }
}
