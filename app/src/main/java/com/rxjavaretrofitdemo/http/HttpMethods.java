package com.rxjavaretrofitdemo.http;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/3/30.
 */

public class HttpMethods {

    private static final String BASEURL = "https://api.douban.com/v2/movie/";
    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private MovieService movieService;

    // 构造方法私有
    private HttpMethods() {
        // 手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  // 添加RxJava2适配器
                .baseUrl(BASEURL)
                .build();

        movieService = retrofit.create(MovieService.class);
    }

    public void getTopMovie(Observer observer, int start, int count) {
        movieService.getTopMovie(start, count)
                .subscribeOn(Schedulers.io())   // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread())  // 指定 Subscriber 的回调发生在主线程
                .subscribe(observer);
    }

    // 在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    // 获取单例
    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
