package com.app.net.core.http;

public enum HttpStatus {
    OK(200, "OK"),
    NOT_FOUND(404, "Not_Found"),
    FORBIDDEN(403, "Forbidden"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed "),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),;

    private int mCode;
    private String mMessage;

    HttpStatus(int code, String message) {
        this.mCode = code;
        this.mMessage = message;
    }

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        this.mCode = code;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        this.mMessage = message;
    }

    public static HttpStatus getValue(int code) {
        for (HttpStatus httpStatus : values()) {
            if (code == httpStatus.mCode) {
                return httpStatus;
            }
        }
        return null;
    }
}
