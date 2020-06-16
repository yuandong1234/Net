package com.app.net;

import com.app.net.callback.HttpCallBack;
import com.app.net.callback.JsonCallBack;
import com.app.net.core.http.HttpBody;
import com.app.net.core.http.HttpRequest;
import com.app.net.core.http.HttpResponse;

import java.io.IOException;

public class HttpRunnable implements Runnable {
    private HttpRequest mRequest;
    private HttpBody mHttpBody;
    private HttpCallBack mHttpCallBack;

    public HttpRunnable(HttpRequest request, HttpBody httpBody, HttpCallBack callBack) {
        this.mRequest = request;
        this.mHttpBody = httpBody;
        this.mHttpCallBack = callBack;
    }

    @Override
    public void run() {
        try {
            addRequestBody(mRequest.getBody());
            HttpResponse response = mRequest.execute();
            //TODO 数据解析 暂时只处理json格式数据
            JsonCallBack callBack = new JsonCallBack(mHttpCallBack);
            if (response.getStatus().getCode() == 200) {
                callBack.success(response);
            } else {
                callBack.fail(response.getStatus().getCode(), response.getStatusMsg());
            }
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addRequestBody(HttpBody body) {
        if (mHttpBody == null) return;
        body.setUrl(mHttpBody.getUrl());
        body.setHttpMethod(mHttpBody.getHttpMethod());
        body.setParams(mHttpBody.getParams());
    }
}
