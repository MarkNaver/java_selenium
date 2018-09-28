package com.contract;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataDemo {
    public String  getCurrentTime() {
        /*
        获取当前时间
         */
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss:SSS");
        //        System.out.print(formatStr);
        return format.format(new Date());
    }
}
