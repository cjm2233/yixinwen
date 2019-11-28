package com.cjm.test2.interfaces;


import com.cjm.test2.bean.News;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by cjm on 2019/3/29.
 */

public interface GetRequst_Interface {
    @GET
    Observable<News> getCall(@Url String url);
}
