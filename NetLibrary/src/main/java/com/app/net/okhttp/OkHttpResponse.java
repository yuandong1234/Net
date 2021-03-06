package com.app.net.okhttp;

import com.app.net.core.AbstractHttpResponse;
import com.app.net.core.http.HttpHeader;
import com.app.net.core.http.HttpStatus;

import java.io.InputStream;

import okhttp3.Response;

public class OkHttpResponse extends AbstractHttpResponse {

    private Response mResponse;

    public OkHttpResponse(Response response) {
        this.mResponse = response;
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.getValue(mResponse.code());
    }

    @Override
    public String getStatusMsg() {
        return mResponse.message();
    }

    @Override
    public HttpHeader getHeader() {
        HttpHeader mHeaders = new HttpHeader();

        for (String name : mResponse.headers().names()) {
            mHeaders.set(name, mResponse.headers().get(name));
        }
        return mHeaders;
    }

    @Override
    protected InputStream getBodyInternal() {
        if (mResponse.body() != null) {
            return mResponse.body().byteStream();
        }
        return null;
    }

    @Override
    protected void closeInternal() {
        if (mResponse.body() != null) {
            mResponse.body().close();
        }
    }
}
