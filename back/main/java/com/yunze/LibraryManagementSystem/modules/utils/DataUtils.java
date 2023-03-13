package com.yunze.LibraryManagementSystem.modules.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 日期转换
 */
public class DataUtils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // 字符串转换为util.Date
    public static java.util.Date strToUtil(String str){
        try{
            return sdf.parse(str);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    // util.Date转换为sql.Date
    public static java.sql.Date utilToSql(java.util.Date date){
        if(date == null){
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

    // util.Date转换为字符串形式
    public static String utilToStr(java.util.Date date){
        return sdf.format (date);
    }

}
