package com.example.admin.zkotlin.http;

import android.content.Context;
import android.util.Log;

import com.example.admin.zkotlin.StringUtil;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by yanchengmeng on 2016/12/29.
 * 请求实现类
 */
public class HttpServiceImpl<T> implements HttpService<T> {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static Context context;

    public HttpServiceImpl(Context context) {
        this.context = context;
    }

    @Override
    public Observable<T> get(final String url, final String accessToken) {
        Observable observable = getObservable(url, accessToken, "");
        return observable;
    }

    @Override
    public Observable<T> getLogout(String url, String appToken) {
        Observable observable = getLogoutObservable(url, appToken,"");
        return observable;
    }

    @Override
    public Observable post(final String url, final String accessToken, final String json) {
        Observable observable = getObservable(url, accessToken, json);
        return observable;
    }

    @Override
    public Observable put(final String url, final String accessToken, final String json) {
        Observable observable = getObservable(url, accessToken, json);
        return observable;
    }

    @Override
    public Observable delete(final String url, final String accessToken) {
        Observable observable = getObservable(url, accessToken, "");
        return observable;
    }


    public static Observable getObservable(final String url, final String accessToken, final String json) {
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    RequestBody body = null;
                    if (!StringUtil.isEmpty(json)) {
                        body = RequestBody.create(JSON, json);
                    }
                    OkHttpClient client = new OkHttpClient();
                    Request request;
                    if (body != null) {
                        request = new Request.Builder()
                                .addHeader(Constant.HEADERNAME, accessToken)
                                .url(url)
                                .post(body)
                                .build();
                    } else {
                        request = new Request.Builder()
                                .addHeader(Constant.HEADERNAME, accessToken)
                                .url(url)
                                .build();
                    }
                    Response response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        Log.e("HttpServiceImpl", "body" + response.message());
                        Log.e("HttpServiceImpl", "response" + response.toString());
//                        JsonUtil.json2map(response.body().toString(),t);
                        String json;
                        String contentType = response.header("Content-Type");
                        if (contentType != null && contentType.contains("application\\json")) {
                            json = response.body().string();
                        } else {
                            json = escapeHtml(response.body().string());
                        }
                        Log.e("HttpServiceImpl", "json" + json);
                        subscriber.onNext(json);
                    } else {
                        throw new IOException(Constant.NETWORK_ERROR);
                    }
                } catch (IOException e) {
                    Log.e("HttpServiceImpl", "IOException" + e.toString());
                    subscriber.onError(new IOException(Constant.NETWORK_ERROR));
                }
                subscriber.onCompleted();
            }
        });
        return observable;
    }

    public static Observable getLogoutObservable(final String url, final String appToken, final String json) {
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    RequestBody body = null;
                    if (!StringUtil.isEmpty(json)) {
                        body = RequestBody.create(JSON, json);
                    }
                    OkHttpClient client = new OkHttpClient();
                    Request request;
                    if (body != null) {
                        request = new Request.Builder()
                                .addHeader("appToken", appToken)
                                .url(url)
                                .post(body)
                                .build();
                    } else {
                        request = new Request.Builder()
                                .addHeader("appToken", appToken)
                                .url(url)
                                .build();
                        Log.e("HttpServiceImpl", request.headers().toString());
                    }
                    Response response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        Log.e("HttpServiceImpl", "body" + response.message());
                        Log.e("HttpServiceImpl", "response" + response.toString());
//                        JsonUtil.json2map(response.body().toString(),t);
                        String json;
                        String contentType = response.header("Content-Type");
                        if (contentType != null && contentType.contains("application\\json")) {
                            json = response.body().string();
                        } else {
                            json = escapeHtml(response.body().string());
                        }
                        Log.e("HttpServiceImpl", "json" + json);
                        subscriber.onNext(json);
                    } else {
                        throw new IOException(Constant.NETWORK_ERROR);
                    }
                } catch (IOException e) {
                    Log.e("HttpServiceImpl", "IOException" + e.toString());
                    subscriber.onError(new IOException(Constant.NETWORK_ERROR));
                }
                subscriber.onCompleted();
            }
        });
        return observable;
    }

    private static String escapeHtml(String content) {
        if (null == content) {
            return content;
        }

        // TODO 确认删除是否影响其他接口
        //content = content.trim().replaceAll("&quot;", "\"");
        return content;
    }
}
