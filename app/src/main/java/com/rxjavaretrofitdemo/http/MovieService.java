package com.rxjavaretrofitdemo.http;

import com.rxjavaretrofitdemo.entity.MovieEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/3/29.
 */

public interface MovieService {
    @GET("top250")
    Call<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);
}
