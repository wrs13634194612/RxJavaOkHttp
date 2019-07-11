package com.example.admin.zkotlin.http;

import rx.Observable;

/**
 * Created by yanchengmeng on 2016/12/29.
 */
public interface HttpService<T> {

    Observable<T> get(String url, String accessToken) ;

    Observable<T> post(String url, String accessToken, String json) ;

    Observable<T> put(String url, String accessToken, String json) ;

    Observable<T> delete(String url, String accessToken) ;

    Observable<T> getLogout(String url, String appToken);
}
