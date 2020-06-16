package com.app.net.core.http;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpHeader implements NameValueMap<String, String> {
    public final static String CONTENT_TYPE = "Content-Type";

    private Map<String, String> mMap = new HashMap<>();

    @Override
    public int size() {
        return mMap.size();
    }

    @Override
    public boolean isEmpty() {
        return mMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return mMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return mMap.containsKey(value);
    }

    @Override
    public String get(Object key) {
        return mMap.get(key);
    }

    @Override
    public String put(String key, String value) {
        return mMap.put(key, value);
    }

    @Override
    public String remove(Object key) {
        return mMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        mMap.putAll(m);
    }

    @Override
    public void clear() {
        mMap.clear();
    }

    @Override
    public Set<String> keySet() {
        return mMap.keySet();
    }

    @Override
    public Collection<String> values() {
        return mMap.values();
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        return mMap.entrySet();
    }

    @Override
    public void set(String name, String value) {
        put(name, value);
    }

    @Override
    public void setAll(Map<String, String> map) {
        putAll(map);
    }

    @Override
    public String get(String name) {
        return mMap.get(name);
    }

    public String getContentType() {
        return get(CONTENT_TYPE);
    }

    public void setContentType(String value) {
        set(CONTENT_TYPE, value);
    }
}
