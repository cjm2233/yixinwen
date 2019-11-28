package com.cjm.test2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cjm.test2.Data.Data;
import com.cjm.test2.MainActivity;
import com.cjm.test2.R;
import com.cjm.test2.activity.NewsActivity;
import com.cjm.test2.adapter.MyRecyclerAdapter;
import com.cjm.test2.bean.News;
import com.cjm.test2.interfaces.GetRequst_Interface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;

/**
 * Created by cjm on 2019/3/24.
 */

public class AttentionFragment extends Fragment {
    private View view;
    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mMyRecyclerAdapter;
    private List<News> datas = new ArrayList<>();;
    private RefreshLayout refreshLayout;
    int i=1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.attention_fragment, container, false);
        initView();
        initData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mMyRecyclerAdapter = new MyRecyclerAdapter(R.layout.item_news, datas);
        mRecyclerView.setAdapter(mMyRecyclerAdapter);
        initListen();
        return view;
    }

    private void initView() {
        mRecyclerView = view.findViewById(R.id.af_rv);
        refreshLayout = view.findViewById(R.id.attention_refresh);
    }

    private void initData() {
        for (int i = 0; i < 11; i++) {
            getData(i+ "");
            Log.i("3456", datas.toString());
        }
    }

    private void initListen() {
        mMyRecyclerAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity().getApplicationContext(), NewsActivity.class);
                intent.putExtra("title", datas.get(position).getTitle());
                intent.putExtra("text", datas.get(position).getText());
                intent.putExtra("sourse", datas.get(position).getSource());
                intent.putExtra("time", datas.get(position).getTime());
                intent.putExtra("image", datas.get(position).getImageViewUrl());
                startActivity(intent);
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
                datas.clear();
                for (int i = 1; i < 11; i++) {
                    getData("" + i);
                }
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
                datas.clear();
                for (int i = 1; i < 11; i++) {
                    getData(i + "");
                }

            }
        });
    }

    private void getData(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.176:8080/v1/news/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final GetRequst_Interface requst = retrofit.create(GetRequst_Interface.class);
        Observable<News> observable = requst.getCall(url);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<News>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("7777", "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(News value) {
                        News news = new News();
                        news.setTitle(value.getTitle());
                        news.setText(value.getText());
                        news.setSource(value.getSource());
                        Log.i("12345",i+"");
                        if (i > 10) {
                            i=1;
                        }
                        switch (i){
                            case 1:
                                news.setImageViewUrl(R.mipmap.ic_a);
                                break;
                            case 2:
                                news.setImageViewUrl(R.mipmap.ic_b);
                                break;
                            case 3:
                                news.setImageViewUrl(R.mipmap.ic_c);
                                break;
                            case 4:
                                news.setImageViewUrl(R.mipmap.ic_d);
                                break;
                            case 5:
                                news.setImageViewUrl(R.mipmap.ic_e);
                                break;
                            case 6:
                                news.setImageViewUrl(R.mipmap.ic_f);
                                break;
                            case 7:
                                news.setImageViewUrl(R.mipmap.ic_g);
                                break;
                            case 8:
                                news.setImageViewUrl(R.mipmap.ic_h);
                                break;
                            case 9:
                                news.setImageViewUrl(R.mipmap.ic_i);
                                break;
                            case 10:
                                news.setImageViewUrl(R.mipmap.ic_j);
                                break;
                        }
                        i++;
                        news.setTime(value.getTime());
                        datas.add(news);
                        mMyRecyclerAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
//                        Toast.makeText(getContext(), "获取失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Log.d("6666", "请求成功");
                    }
                });
    }
}
