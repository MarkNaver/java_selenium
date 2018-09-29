package com.config.selenium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileChaseFW {

    /**
     * 把合同编号及合同总价写入txt并换行
     * @param filePath
     * @param ContractNo
     * @param contractPrice
     */
//    public static void fileChase(String filePath, String ContractNo,String contractPrice) {
//        try {
//            FileWriter fileWriter = new FileWriter(filePath, true);
//            fileWriter.write(ContractNo + "," + contractPrice + '\n');
//            fileWriter.close();
//        } catch (IOException e) {
//            System.out.println("文件写入失败" + e);
//        }
//    }

//    /**
//     * 读取文件最后一行数据，传入文件路径即可
//     *
//     * @param filePath
//     */
//    public static String readEndData(String filePath) {
//        String str2 = null;
//        try {
////            String str2 = null;
//            FileReader fileReader = new FileReader(filePath);
//            BufferedReader br = new BufferedReader(fileReader);
//            String str;
//            while ((str = br.readLine()) != null) {
//                str2 = str;
//            }
//            br.close();
//            fileReader.close();
////            System.out.println(str2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return str2;
//    }

}
