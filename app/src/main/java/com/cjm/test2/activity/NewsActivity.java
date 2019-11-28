package com.cjm.test2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjm.test2.R;

/**
 * Created by cjm on 2019/3/28.
 */

public class NewsActivity extends AppCompatActivity {
    private TextView title, time, text, sourse;
    private ImageView mImageView;
    private String mTitle, mTime, mText, mSourse;
    private int mImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
        initView();
        initData();
    }


    private void initData() {
        Intent intent = getIntent();
        mTitle = intent.getStringExtra("title");
        mText = intent.getStringExtra("text");
        mSourse = intent.getStringExtra("sourse");
        mTime = intent.getStringExtra("time");
        mImage = intent.getIntExtra("image",-1);
        title.setText(mTitle);
        text.setText(mText);
        sourse.setText(mSourse);
        time.setText(mTime);
        mImageView.setImageResource(mImage);
    }

    private void initView() {
        title = findViewById(R.id.news_tv1);
        text = findViewById(R.id.news_tv2);
        sourse = findViewById(R.id.news_tv3);
        time = findViewById(R.id.news_tv4);
        mImageView = findViewById(R.id.news_img);
    }
}
