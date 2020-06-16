package com.app.net.okhttp;

import com.app.net.core.AbstractHttpRequest;
import com.app.net.core.http.HttpBody;
import com.app.net.core.http.HttpHeader;
import com.app.net.core.http.HttpMethod;
import com.app.net.core.http.HttpResponse;

import java.io.IOException;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpRequest extends AbstractHttpRequest {
    private OkHttpClient mClient;

    public OkHttpRequest(OkHttpClient client) {
        this.mClient = client;
    }

    @Override
    public String getUrl() {
        return getBody().getUrl();
    }

    @Override
    public HttpMethod getMethod() {
        return getBody().getHttpMethod();
    }

    @Override
    protected HttpResponse executeInternal(HttpHeader headers, HttpBody body) throws IOException {
        Request.Builder builder = new Request.Builder();

        RequestBody requestBody = getRequestBody(body.getParams());

        HttpMethod mMethod = body.getHttpMethod();

        if (mMethod == HttpMethod.GET) {
            builder.url(getUrl()).get();
        } else {
            builder.url(getUrl()).post(requestBody);
        }

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }

        Request request = builder.build();

        Response response = mClient.newCall(request).execute();

        return new OkHttpResponse(response);
    }


    private RequestBody getRequestBody(Map<String, String> params) {
        //TODO 暂时只处理表单数据
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }
}
