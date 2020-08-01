package com.tftte.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: tftte
 * @Date: 2020/6/14 21:32
 * @Description: 日期转换器(将界面中拿到的字符串转换为日期)
 */
@Component
public class DateConverter implements Converter<String, Date> {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-HH-mm");

    @Override
    public Date convert(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        try {
            Date date = simpleDateFormat.parse(s);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
