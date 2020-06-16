package com.app.net;

import com.app.net.core.http.HttpRequest;

public interface HttpFactory {

    HttpRequest createHttpRequest();

    void setReadTimeOut(int readTimeOut);

    void setWriteTimeOut(int writeTimeOut);

    void setConnectionTimeOut(int connectionTimeOut);
}
