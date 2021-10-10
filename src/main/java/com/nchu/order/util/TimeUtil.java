package com.nchu.order.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间信息处理工具类
 */
public  class TimeUtil {
    private static Date day = new Date();


    private TimeUtil(){}


    public static String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return sdf.format(day);
    }
}
