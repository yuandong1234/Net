package com.app.net;

import com.app.net.core.http.HttpRequest;
import com.app.net.okhttp.OkHttpFactory;

public class HttpProvider {
    private HttpFactory mHttpFactory;

    public HttpProvider() {
        //TODO 目前仅用OkHttp 实现
        mHttpFactory = new OkHttpFactory();
    }

    public HttpRequest getHttpRequest() {
        return mHttpFactory.createHttpRequest();
    }

    public HttpFactory getHttpFactory() {
        return mHttpFactory;
    }

    public void setHttpFactory(HttpFactory httpFactory) {
        this.mHttpFactory = httpFactory;
    }
}
