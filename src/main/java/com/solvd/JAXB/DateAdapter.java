package com.solvd.JAXB;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter <String, Date> {
    private final SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date unmarshal(String s) throws Exception {
        synchronized (dateFormat){
            return dateFormat.parse(s);
        }
    }

    @Override
    public String marshal(Date date) throws Exception {
        synchronized (dateFormat){
            return dateFormat.format(date);
        }
    }
}
