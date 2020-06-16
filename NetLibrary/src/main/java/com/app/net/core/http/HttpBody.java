package com.app.net.core.http;

import java.util.Map;

public class HttpBody {
    private String mUrl;
    private HttpMethod mHttpMethod;
    private Map<String, String> mParams;
    //TODO 其他的数据类型暂时不处理（File 、json 、多类型表单数据等）


    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public HttpMethod getHttpMethod() {
        return mHttpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.mHttpMethod = httpMethod;
    }

    public Map<String, String> getParams() {
        return mParams;
    }

    public void setParams(Map<String, String> params) {
        this.mParams = params;
    }
}
