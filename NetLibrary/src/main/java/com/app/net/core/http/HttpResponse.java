package com.app.net.core.http;

import java.io.IOException;
import java.io.InputStream;

public interface HttpResponse {
    HttpStatus getStatus();

    String getStatusMsg();

    HttpHeader getHeader();

    InputStream getBody() throws IOException;

    void close();
}
