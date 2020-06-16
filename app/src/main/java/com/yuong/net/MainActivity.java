package com.yuong.net;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.app.net.HttpProvider;
import com.app.net.HttpRunnable;
import com.app.net.callback.HttpCallBack;
import com.app.net.core.http.HttpBody;
import com.app.net.core.http.HttpMethod;
import com.app.net.core.http.HttpRequest;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final static String APP_KEY = "aa47561558f285fee99f1943c7b844fb";
    private final static String URL = "http://v.juhe.cn/toutiao/index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        findViewById(R.id.btn_request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doRequest();
            }
        });
    }


    private void doRequest() {
        Map<String, String> params = new HashMap<>();
        params.put("key", APP_KEY);
        params.put("type", "top");

        HttpBody body = new HttpBody();
        body.setHttpMethod(HttpMethod.POST);
        body.setUrl(URL);
        body.setParams(params);

        HttpProvider httpProvider = new HttpProvider();
        HttpRequest request = httpProvider.getHttpRequest();

        HttpRunnable runnable = new HttpRunnable(request, body, new HttpCallBack<News>() {
            @Override
            public void success(News data) {
                Log.e("MainActivity", "请求数据： " + data.toString());
            }

            @Override
            public void fail(int errorCode, String errorMsg) {

            }
        });


        new Thread(runnable).start();
    }
}
