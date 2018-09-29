package com.common;

import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
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
    private static String configFilePath(String fileName) {
        //获取工程目录
        File file = new File(System.getProperty("user.dir") +
                File.separator + "src" +
                File.separator + "main" +
                File.separator + "java" +
                File.separator + "ConfigurationFile" +
                File.separator + fileName
                );
        //配置文件目录
        return String.valueOf(file);
    }


    /**
     * projectPath获取到的文件路径传入当前方法，读取地址、用户名、密码，返回一个列表
     * @param
     * @return
     * @throws IOException
     */
    private ArrayList<String> userConfig() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(configFilePath("config.properties"));
        properties.load(inputStream);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(properties.getProperty("apiUrl"));
        arrayList.add(properties.getProperty("username"));
        arrayList.add(properties.getProperty("password"));
        inputStream.close();
        return arrayList;
    }

//    private ArrayList<String> getArrayList() throws IOException {
//        ArrayList<String> arrayList;
//
//        arrayList = userConfig(projectPath());
//        System.out.println(arrayList.get(0));
//        return arrayList;
//
//    }


    /**
     * 获取token
     * @return
     * @throws IOException
     */
    private String getToken() throws IOException {

        ArrayList<String> arrayList;
        arrayList = userConfig();

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

    /**
     * 读取excel文件，需要传入表格名，行标，列标来查询具体数据
     * @param sheetName
     * @param rowNum
     * @param cellNum
     * @return
     */
    public String  redExcel(String sheetName,int rowNum,int cellNum) {
        XSSFWorkbook xssfWorkbook;
        XSSFSheet xssfSheet;
        XSSFCell xssfCell;

        String path = configFilePath("execldemo.xlsx");
//        String sheetName = "LoginTests";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
            xssfSheet = xssfWorkbook.getSheet(sheetName);
            xssfCell = xssfSheet.getRow(rowNum).getCell(cellNum);
            //            System.out.println("单元格数据是：" + cellData);
            return xssfCell.getStringCellValue();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public  void fileChase(String txtFileName, String value1,String value2) {
        try {
            FileWriter fileWriter = new FileWriter(configFilePath(txtFileName), true);
            fileWriter.write(value1 + "," +  value2 + '\n');
            fileWriter.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    /**
     * 读取文件最后一行数据，传入txt文件名即可即可
     *
     * @param
     */
    public String readEndData(String txtFileName) {
        String str2 = null;
        try {
//            String str2 = null;
            FileReader fileReader = new FileReader(configFilePath(txtFileName));
            BufferedReader br = new BufferedReader(fileReader);
            String str;
            while ((str = br.readLine()) != null) {
                str2 = str;
            }
            br.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str2;
        //可以根据需要分隔数据
        //String[] arr = AA.split(",");
        //System.out.println(arr[1]);
    }

    public static void main(String[] args) throws IOException {
        Config config = new Config();
//        config.getToken();
        System.out.println(config.getToken());
//        System.out.println(config.projectPath("config.properties"));
//        config.getArrayList();
//        System.out.println(config.redExcel("LoginTests",2,2));
//        System.out.println(config.readEndData("data.txt"));
//        config.fileChase("da.txt","one","two");
    }

}
