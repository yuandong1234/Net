package com.app.net.core.http;

public enum ContentType {
    JSON("application/json;charset=UTF-8"),
    FORM("application/x-www-form-urlencoded");

    private String mValue;

    ContentType(String value) {
        this.mValue = value;
    }

    public String getValue() {
        return mValue;
    }

}
