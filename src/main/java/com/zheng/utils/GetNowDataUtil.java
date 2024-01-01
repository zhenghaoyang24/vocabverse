package com.zheng.utils;

import java.util.Calendar;

public class GetNowDataUtil {

    private static Calendar cal;

    public static String getNowData() {


        /*获取现在时间*/
        cal=Calendar.getInstance();
        int y=cal.get(Calendar.YEAR);
        int m=cal.get(Calendar.MONTH);
        int d=cal.get(Calendar.DATE);
//        int h=cal.get(Calendar.HOUR_OF_DAY);
//        int mi=cal.get(Calendar.MINUTE);
//        int se=cal.get(Calendar.SECOND);
        return y+"-"+m+"-"+d;

    }





}

