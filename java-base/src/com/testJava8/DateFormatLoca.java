package com.testJava8;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateFormatLoca
 * @Author: ChenBJ
 * @Description: TODO
 * @Date: 2018/8/23 15:28
 * @Version:
 */
public class DateFormatLoca {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){

        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyyMMdd");
        }

    };

    public static final Date convert(String source) throws ParseException{
        return df.get().parse(source);
    }
}
