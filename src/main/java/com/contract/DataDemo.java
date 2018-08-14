package com.contract;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataDemo {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss:SSS");
        String formatStr = format.format(new Date());
        System.out.printf(formatStr);

//    }
//    private static void main(String[] args) {
//        Date date1 = new Date();
//
//        SimpleDateFormat df = new SimpleDateFormat(format);
//
//        return df.format(date);
//        String logTime = new Date()
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
//        String formatStr = format.format(new Date());
//        System.out.printf(formatStr);

    }
//    public static void main(String[] args) {
//        Date date1 = new Date();
//        String logTime = getDateTimeByFormat(date, "yyyy-MM-dd|HH:mm:ss-SSS");
//        System.out.println(logTime);
//    }
}
