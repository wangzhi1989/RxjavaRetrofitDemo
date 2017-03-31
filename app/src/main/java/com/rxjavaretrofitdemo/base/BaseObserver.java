package com.rxjavaretrofitdemo.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import com.rxjavaretrofitdemo.entity.MovieEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/3/31.
 */

public abstract class BaseObserver<T> implements Observer<MovieEntity<T>> {
    private Disposable disposable;
    private ProgressDialog progressDialog;
    private Context context;

    public BaseObserver(Context context, ProgressDialog progressDialog) {
        this.context = context;
        this.progressDialog = progressDialog;

        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                disposable.dispose();
            }
        });
    }

    @Override
    public void onSubscribe(Disposable d) {
        // 最先回调，没有执行onNext、onComplete、onError也会回调
        Log.d("wz", "onSubscribe: "+d.toString());

        //d.dispose();  //移除订阅关系

        //d.isDisposed(); //判断取消了订阅关系，为真就是没有订阅，假就是有订阅中
    }

    /**
     * 被观察者调用onNext这里就会回调
     */
    @Override
    public void onNext(MovieEntity<T> value) {
        Log.d("wz","onNext"+value);
        // 正常接收数据调用
        T t = value.getSubjects();
        onHandleSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        //  发生错误调用
        Log.d("wz", "error:" + e.toString());

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

        Toast.makeText(context, "网络异常，请稍后再试", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete() {
        // 数据接收完成时调用
        Log.d("wz", "onComplete");

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    protected abstract void onHandleSuccess(T t);
}
