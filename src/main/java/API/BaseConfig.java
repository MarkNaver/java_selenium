//package API;
//
//import com.alibaba.fastjson.JSONObject;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Map;
//
///**
// * @Author: tcwaily@me.com
// * @Description:
// * @Date: Created in 下午3:39 2018/9/29
// * @Modified By:
// */
//public class BaseConfig {
//    private String getToken() throws IOException {
//
////        ArrayList<String> arrayList;
////        arrayList = userConfig();
////
////        OkHttpClient client = new OkHttpClient();
////        Request request = new Request.Builder()
////                .url(arrayList.get(0))
////                .get()
////                .addHeader("username", arrayList.get(1))
////                .addHeader("password", arrayList.get(2))
////                .build();
////
////        Response response = client.newCall(request).execute();
////        assert response.body() != null;
////        String result = response.body().string();
////        Map<String, Object> map;
////        map = JSONObject.parseObject(result);
//////        System.out.println(map.get("Access-Token"));
////        return (String) map.get("Access-Token");
//    }
//}
