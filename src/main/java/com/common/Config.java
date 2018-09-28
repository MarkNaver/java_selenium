package com.common;

import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class Config {
    /**
     * 返回配置文件路径
     * @return
     */
    private String projectPath() {
        //获取工程目录
        String path = System.getProperty("user.dir");
        //配置文件目录
        String configFilePath = "/Config.properties";
        return path + configFilePath;
    }

    private ArrayList<String> userConfig(String configPath) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(projectPath());
        properties.load(inputStream);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(properties.getProperty("apiUrl"));
        arrayList.add(properties.getProperty("username"));
        arrayList.add(properties.getProperty("password"));
        inputStream.close();
        return arrayList;
    }

    private ArrayList<String> getArrayList() throws IOException {
        ArrayList<String> arrayList;

        arrayList = userConfig(projectPath());
        System.out.println(arrayList.get(0));
        return arrayList;

    }


    /**
     * 获取token
     * @return
     * @throws IOException
     */
    private String getToken() throws IOException {

        ArrayList<String> arrayList;
        arrayList = userConfig(projectPath());

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(arrayList.get(0))
                .get()
                .addHeader("username", arrayList.get(1))
                .addHeader("password", arrayList.get(2))
                .build();

        Response response = client.newCall(request).execute();
        assert response.body() != null;
        String result = response.body().string();
        Map<String, Object> map;
        map = JSONObject.parseObject(result);
//        System.out.println(map.get("Access-Token"));
        return (String) map.get("Access-Token");
    }


    /**
     * 获取当前时间
     * @return
     */
    public String  getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss:SSS");
        //        System.out.print(formatStr);
        return format.format(new Date());
    }

    public static void main(String[] args) throws IOException {
        Config config = new Config();
        config.getToken();
        System.out.println(config.getToken());
//        config.projectPath();
//        config.getArrayList();
    }

}
