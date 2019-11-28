package com.cjm.test2.interfaces;

import com.cjm.test2.bean.News;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by cjm on 2019/7/9.
 */

public interface Api {
    @GET("")
    Observable<News> getCall();
}
