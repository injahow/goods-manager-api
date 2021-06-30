package com.injahow.booksManager.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DataConverter implements Converter<String, Date> {

    public Date convert(String s) {
        String[] dateFormat = new String[]{"yyyy年MM月dd日", "yyyy/MM/dd","yyyy.MM.dd","yyyy-MM-dd"};
        int i=0;
        for(; i<dateFormat.length; ++i){

        }
        s.indexOf(".");
        Date date = null;
        try {
            date = new SimpleDateFormat(dateFormat[i]).parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
