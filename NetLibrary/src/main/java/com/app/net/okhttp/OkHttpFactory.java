package com.app.net.okhttp;

import com.app.net.HttpFactory;
import com.app.net.core.http.HttpRequest;

import okhttp3.OkHttpClient;

public class OkHttpFactory implements HttpFactory {

    private OkHttpClient mClient;

    public OkHttpFactory() {
        mClient = new OkHttpClient();
    }

    @Override
    public HttpRequest createHttpRequest() {
        return new OkHttpRequest(mClient);
    }
}
