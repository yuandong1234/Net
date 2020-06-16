package com.yuong.net;

import android.os.Bundle;
import android.util.Log;

import com.app.net.HttpRunnable;
import com.app.net.callback.HttpCallBack;
import com.app.net.core.http.HttpBody;
import com.app.net.core.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void getData() {
        String url = "http://v.juhe.cn/toutiao/index";
        String APPKEY = "aa47561558f285fee99f1943c7b844fb";
        Map<String, String> params = new HashMap<>();
        params.put("key", APPKEY);
        params.put("type", "top");

        HttpBody body = new HttpBody();
        body.setHttpMethod(HttpMethod.POST);
        body.setUrl(url);
        body.setParams(params);


        //HttpRunnable runnable=new HttpRunnable();


        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

    }
}
