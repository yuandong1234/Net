package com.app.net.core.http;

import java.util.Map;

public interface NameValueMap<K, V> extends Map<K, V> {

    void set(String name, String value);

    void setAll(Map<String, String> map);

    String get(String name);
}
