package com.example.admin.zkotlin.http;

import android.content.Context;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yanchengmeng on 2016/12/29.
 * Http请求工具类
 */
public class HttpManager {

    private static HttpManager httpManager;
    private static Context httpContext;
    //创建实现接口调用
    protected static HttpService service;
    private static HttpServiceImpl httpService;

    public static HttpManager getInstance(Context context) {
        httpContext = context.getApplicationContext();
//        service=getRetrofit(httpContext).create(HttpService.class);
        httpService = new HttpServiceImpl(httpContext);
        if (httpManager == null) {
            httpManager = new HttpManager();
        }
        return httpManager;
    }

    /**
     * Get请求
     */
    public void getJson(String url, String accessToken, Observer<String> observer) {
        setSubscribe(httpService.get(url, accessToken), observer);
    }

    public void getLogoutJson(String url, String appToken, Observer<String> observer) {
        setSubscribe(httpService.getLogout(url, appToken), observer);
    }

    /**
     * Post请求
     */
    public void post(String url, String accessToken, String json, Observer<String> observer) {
        setSubscribe(httpService.post(url, accessToken, json), observer);
    }

    /**
     * Put请求
     */
    public <T> void put(String url, String accessToken, String json, Observer<T> observer) {
        setSubscribe(httpService.put(url, accessToken, json), observer);
    }

    /**
     * Delete请求
     */
    public <T> void delete(String url, String accessToken, Observer<T> observer) {
        setSubscribe(httpService.delete(url, accessToken), observer);
    }

    public <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())            //IO线程访问网络数据
                .observeOn(AndroidSchedulers.mainThread()) //回调到主线程
                .subscribe(observer);
    }
}
