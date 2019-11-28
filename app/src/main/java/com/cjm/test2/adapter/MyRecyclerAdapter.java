package com.cjm.test2.adapter;

import android.app.Application;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cjm.test2.R;
import com.cjm.test2.bean.News;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cjm on 2019/3/24.
 */

public class MyRecyclerAdapter extends BaseQuickAdapter<News, BaseViewHolder> {
    public MyRecyclerAdapter(@LayoutRes int layoutResId, @Nullable List<News> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, News item) {
        Log.i("2345",item.getText());
        helper.setText(R.id.recycler_text1, item.getTitle())
                .setText(R.id.recycler_text2, item.getText())
                .setImageResource(R.id.item_iv, item.getImageViewUrl())
                .setText(R.id.recycler_text3, item.getSource())
                .setText(R.id.recycler_text4, stampToDate(item.getTime() + ""));
    }

    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
