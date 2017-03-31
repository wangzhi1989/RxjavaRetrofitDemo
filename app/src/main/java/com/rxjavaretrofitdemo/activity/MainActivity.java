package com.rxjavaretrofitdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjavaretrofitdemo.R;
import com.rxjavaretrofitdemo.entity.MovieEntity;
import com.rxjavaretrofitdemo.http.HttpMethods;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.textView)
    TextView textView;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void OnClick() {
        getMovie();
    }

    // 进行网络请求
    private void getMovie() {
        Observer observer = new Observer<MovieEntity>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MovieEntity movieEntity) {
                textView.setText(movieEntity.toString());
            }

            @Override
            public void onError(Throwable e) {
                textView.setText(e.getMessage());
            }

            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
            }

        };

        HttpMethods.getInstance().getTopMovie(observer, 0, 10);
    }
}