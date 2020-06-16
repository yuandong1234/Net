package com.app.net.core;

import com.app.net.core.http.HttpBody;
import com.app.net.core.http.HttpHeader;
import com.app.net.core.http.HttpRequest;
import com.app.net.core.http.HttpResponse;

import java.io.IOException;

public abstract class AbstractHttpRequest implements HttpRequest {
    private HttpHeader mHeader = new HttpHeader();
    private HttpBody mBody = new HttpBody();

    @Override
    public HttpHeader getHeader() {
        return mHeader;
    }

    @Override
    public HttpBody getBody() {
        return mBody;
    }

    @Override
    public HttpResponse execute() throws IOException {
        return executeInternal(mHeader, mBody);
    }

    protected abstract HttpResponse executeInternal(HttpHeader headers, HttpBody body) throws IOException;

}
