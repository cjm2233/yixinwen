package com.cjm.test2.bean;

import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cjm on 2019/3/24.
 */

public class News {
    //来源
    private String Source;
    //标题
    private String Title;
    //内容
    private String Text;
    //图片
    private int Imageviewurl;
    //时间
    private int Time;

    public News() {
    }

    public News(String text, String title, int imageView, String source, int time) {
        this.Text = text;
        this.Title = title;
        this.Imageviewurl = imageView;
        this.Source = source;
        this.Time = time;
    }

    public String getText() {
        return Text;
    }


    public void setText(String text) {

        this.Text = text;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public int getImageViewUrl() {
        return Imageviewurl;
    }

    public void setImageViewUrl(int imageView) {
        this.Imageviewurl = imageView;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        this.Source = source;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        this.Time = time;
    }
}
