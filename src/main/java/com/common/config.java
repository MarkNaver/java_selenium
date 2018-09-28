package com.common;

import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class config extends Thread{
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://api.yun-idc.com/gic/v1/get_token/gic/v1/get_token/")
                .get()
                .addHeader("username", "tcwaily@me.com")
                .addHeader("password", "test123")
                .build();

        Response response = client.newCall(request).execute();
        assert response.body() != null;
        String result = response.body().string();
        System.out.println(result);

        Map<String, Object> map;
        map = JSONObject.parseObject(result);
        System.out.println(map.get("Access-Token"));

    }

}
