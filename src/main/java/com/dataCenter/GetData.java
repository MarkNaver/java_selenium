package com.dataCenter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetData {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static String getCurrentData() {
        return format.format(new Date());
    }

    public static String getCurrentData1() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH,7);
        return format.format(c.getTime());

    }

//    public static void main(String[] args) {
//        System.out.println(getCurrentData());
//        System.out.println(getCurrentData1());
//    }

}
