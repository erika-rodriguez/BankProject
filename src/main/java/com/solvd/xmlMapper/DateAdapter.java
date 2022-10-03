package com.solvd.xmlMapper;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAdapter extends XmlAdapter <String, LocalDate> {
    private final DateTimeFormatter dateFormat= DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //private final SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public LocalDate unmarshal(String s) throws Exception {
        synchronized (dateFormat){
            return LocalDate.parse(s,dateFormat);
        }
    }

    @Override
    public String marshal(LocalDate date) throws Exception {
        synchronized (dateFormat){
            return dateFormat.format(date);
        }
    }
}
