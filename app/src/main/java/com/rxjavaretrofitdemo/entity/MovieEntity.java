package com.rxjavaretrofitdemo.entity;

/**
 * Created by Administrator on 2017/3/29.
 * https://api.douban.com/v2/movie/top250?start=0&count=10
 */

public class MovieEntity<T> {

    private String count;
    private String start;
    private String total;
    private String title;

    // 用来模仿Data
    private T subjects;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public T getSubjects() {
        return subjects;
    }

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("title=" + title + " count=" + count + " start=" + start);
        if (subjects != null) {
            stringBuffer.append(" subjects=" + subjects);
        }
        return stringBuffer.toString();
    }
}