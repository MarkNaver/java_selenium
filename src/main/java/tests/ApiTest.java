package tests;

import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

/**
 * @Author: tcwaily@me.com
 * @Description:
 * @Date: Created in 下午3:48 2018/9/29
 * @Modified By:
 */
public class ApiTest extends BaseTest{

    @BeforeClass
    public void setUp() {
        System.out.println("setUp");
    }

    @Parameters({"ApiURL","username", "password"})
    @Test
    public void testApi(String ApiURL,String username,String password) throws IOException {
        System.out.println("testApi");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiURL)
                .get()
                .addHeader("username", username)
                .addHeader("password", password)
                .build();

        Response response = client.newCall(request).execute();
        assert response.body() != null;
        String result = response.body().string();
        Map<String, Object> map;
        map = JSONObject.parseObject(result);
        System.out.println(map.get("status"));
        System.out.println(map.get("Access-Token"));
        Assert.assertEquals("success",map.get("status"));
    }

//    /**
//     * 接口获取列表信息，token待优化
//     * @param ApiList
//     * @throws IOException
//     */
//    @Parameters({"ApiList"})
//    @Test
//    public void testApiList(String ApiList) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(ApiList)
//                .get()
//                .addHeader("token", "b1f392c478405566515797b64aca6075c43a34ec9f0c9d08897c6ef66dea9097")
//                .build();
//        Response response = client.newCall(request).execute();
//        assert response.body() != null;
//        String result = response.body().string();
//        Map<String, Object> map;
//        map = JSONObject.parseObject(result);
//        System.out.println(map.get("code"));
//    }

    @AfterClass
    public void tearDown() {
        System.out.println("tearDown");
    }
}
