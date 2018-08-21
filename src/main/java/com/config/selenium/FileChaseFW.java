package com.config.selenium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileChaseFW {

    /**
     * 数据写入文件，传入文件路径及写入的数据
     *
     * @param filePath
     * @param content
     */
    public static void fileChase(String filePath, String content) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.write(content + '\n');
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("文件写入失败" + e);
        }
    }

    /**
     * 读取文件最后一样数据，传入文件路径即可
     *
     * @param filePath
     */
    public static void readEndData(String filePath) {
        try {
            String str2 = null;
            FileReader fileReader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fileReader);
            String str;
            while ((str = br.readLine()) != null) {
                str2 = str;
            }
            br.close();
            fileReader.close();
            System.out.println(str2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
