package com.app.net.core.http;

import java.io.IOException;

public interface HttpRequest {
    String getUrl();

    HttpMethod getMethod();

    HttpHeader getHeader();

    void setBody(HttpBody httpBody);

    HttpBody getBody();

    HttpResponse execute() throws IOException;
}
