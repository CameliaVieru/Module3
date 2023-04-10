package com.example.temacurs13;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class TimeZone1 {

    String timeZone;

    TimeZone1(String timeZone){
        this.timeZone = timeZone;
    }

    public String getTimeZone(){
        SimpleDateFormat f = new SimpleDateFormat("HH:mm:SS Z");
            if(timeZone.equals("UTC")){
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                f.setTimeZone(calendar.getTimeZone());
                return f.format(calendar.getTime());
            } else if(timeZone.equals("CET")){
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("CET"));
                f.setTimeZone(calendar.getTimeZone());
                return f.format(calendar.getTime());
            } else if(timeZone.equals("EET")){
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("EET"));
                f.setTimeZone(calendar.getTimeZone());
                return f.format(calendar.getTime());
            } else if(timeZone.equals("GMT")){
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
                f.setTimeZone(calendar.getTimeZone());
                return f.format(calendar.getTime());
            } else if(timeZone.equals("EAT")){
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("EAT"));
                f.setTimeZone(calendar.getTimeZone());
                return f.format(calendar.getTime());
            }
        return null;
    }
}
