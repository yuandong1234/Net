package com.app.net;

import com.app.net.core.http.HttpRequest;

public interface HttpFactory {

    HttpRequest createHttpRequest();
}
