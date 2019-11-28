//package com.cjm.test2.util;
//
//import com.cjm.test2.interfaces.Api;
//import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//import okhttp3.FormBody;
//import okhttp3.HttpUrl;
//import okhttp3.Interceptor;
//import okhttp3.MultipartBody;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
///**
// * Created by cjm on 2019/7/9.
// */
//
//public class RetrofitHelper {
//    private static OkHttpClient mOkHttpClient;
//
//    private RetrofitHelper() {
//        throw new UnsupportedOperationException("u can't init me");
//    }
//
//    static {
//        initOkHttpClient();
//    }
//
//    //创建一个请求
//    public static Api getBoobApi() {
//        return createApi(Api.class, "https://api.douban.com/");
//    }
//
//
//    /**
//     * 根据传入的baseUrl，和api创建retrofit
//     */
//    private static <T> T createApi(Class<T> clazz, String baseUrl) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl) //这个一般是接口地址（一定要以/结尾）
//                .client(mOkHttpClient)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //集成rxjava
//                .addConverterFactory(GsonConverterFactory.create()) //gson解析
//                .build();
//        return retrofit.create(clazz);
//    }
//
//
//    /**
//     * 初始化OKHttpClient,设置超时时间,设置打印日志,设置Request拦截器
//     */
//    private static void initOkHttpClient() {
//        //打印所有okhttp请求日志
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        if (mOkHttpClient == null) {
//            synchronized (RetrofitHelper.class) {
//                if (mOkHttpClient == null) {
//                    mOkHttpClient = new OkHttpClient.Builder()
//                            .addInterceptor(interceptor)//添加网络log拦截器
//                            .addInterceptor(new RequestInterceptor())//添加网络请求拦截器
//                            .retryOnConnectionFailure(true) //当失败时重复请求
//                            .connectTimeout(30, TimeUnit.SECONDS)//连接超时时间
//                            .writeTimeout(20, TimeUnit.SECONDS)
//                            .readTimeout(20, TimeUnit.SECONDS)
//                            .build();
//                }
//            }
//        }
//    }
//
//    private static class RequestInterceptor implements Interceptor {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
//            if (request.method().equals("POST")) {
//                //这里分两种post提交方式
//                // FormBoy:以表单方式提交  MultipartBody:是有多个参数(其中包括文件)
//                if (request.body() instanceof FormBody) {
//                    request = addPostFormParams(request);
//                } else if (request.body() instanceof MultipartBody) {
//                    request = addPostMultiParams(request);
//                }
//            } else if (request.method().equals("GET")) {
//                request = addGetParams(chain);
//            }
//            return chain.proceed(request);
//        }
//    }
//
//    //post附带图片时
//    private static Request addPostMultiParams(Request request) {
//        // 添加公共参数
//        MultipartBody.Builder builder = new MultipartBody.Builder().addFormDataPart("deviceId", "123456");
//        MultipartBody oldBody = (MultipartBody) request.body();
//        for (int i = 0; i < oldBody.size(); i++) {
//            builder.addPart(oldBody.part(i));
//        }
//        oldBody = builder.build();
//        request = request.newBuilder().post(oldBody).build();
//        return request;
//    }
//
//    //post参数时
//    private static Request addPostFormParams(Request request) {
//        FormBody.Builder bodyBuilder = new FormBody.Builder();
//        FormBody formBody = (FormBody) request.body();
//        //把原来的参数添加到新的构造器，（因为没找到直接添加，所以就new新的）
//        for (int i = 0; i < formBody.size(); i++) {
//            bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
//        }
//        //添加公共参数
//        formBody = bodyBuilder
//                .addEncoded("deviceId", "123456").build();
//        request = request.newBuilder().post(formBody).build();
//        return request;
//    }
//
//    private static Request addGetParams(Interceptor.Chain chain) {
//        Request request;
//        Request oldRequest = chain.request();
//        // 添加公共参数
//        HttpUrl authorizedUrlBuilder = oldRequest.url()
//                .newBuilder()
//                .addQueryParameter("deviceId", "123456").build();
//        request = oldRequest.newBuilder()
//                .url(authorizedUrlBuilder)
//                .build();
//        return request;
//    }
//}
