package com.rxjavaretrofitdemo.http;

import com.rxjavaretrofitdemo.entity.MovieEntity;
import com.rxjavaretrofitdemo.entity.Subject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/3/29.
 */

public interface MovieService {
//    @GET("top250")
//    Call<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);

    @GET("top250")
    Observable<MovieEntity<Subject>> getTopMovie(@Query("start") int start, @Query("count") int count);

}
