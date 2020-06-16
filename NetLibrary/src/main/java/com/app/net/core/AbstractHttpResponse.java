package com.app.net.core;

import com.app.net.core.http.HttpResponse;

import java.io.InputStream;

public abstract class AbstractHttpResponse implements HttpResponse {

    @Override
    public InputStream getBody() {
        return getBodyInternal();
    }

    @Override
    public void close() {
        closeInternal();
    }

    protected abstract InputStream getBodyInternal();

    protected abstract void closeInternal();
}
