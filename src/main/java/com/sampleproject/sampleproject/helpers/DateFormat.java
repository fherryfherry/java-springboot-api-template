package com.sampleproject.sampleproject.helpers;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DateFormat {

    String formatDateIndo = "dd MMMM yyyy HH:mm:ss";
    //            =================================================
    //    dd/MM/yy         ---> 06/04/14
    //    dd MMMM yyyy         ---> 06 April 2014
    //    EEEE, dd MMMM, ''yy  ---> Minggu, 06 April, '14
    //    h:mm a           ---> 6:19 PM
    //    H:mm             ---> 18:19
    //    H:mm:ss:SSS      ---> 18:19:48:838
    //    yyyy.MM.dd G 'at' hh:mm:ss z         ---> 2014.04.06 CE at 06:19:48 ICT
    //    yyyy.MMMMM.dd GGG hh:mm aaa      ---> 2014.April.06 CE 06:19 PM
    //    dd MMMM yyyy', Pukul' HH:mm:ss:SSSSS     ---> 06 April 2014, Pukul 18:19:48:00838
    //    EEEE, dd MMMM, yyyy          ---> dimanche, 06 avril, 2014 (Lokal yng dipakai = French (France))
    //    Dalam format timestamp = 1396783188838

    public static int getCurrentYear()
    {
        Date date = new Date();
        return date.getYear();
    }

    public static Date getFirstDateOfYear(int year) throws ParseException {
        return DateFormat.stringToDate(year+"-01-01 00:00:01","yyyy-MM-dd HH:mm:ss");
    }

    public static Date getLastDateOfYear(int year) throws ParseException {
        return DateFormat.stringToDate(year+"-12-31 23:59:59","yyyy-MM-dd HH:mm:ss");
    }

    public static int getCurrentMonth()
    {
        Date date = new Date();
        return date.getMonth();
    }

    public static Date getDateWithoutTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    public static Date getTomorrowDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    public static String dateToString(Date date, String format)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String output = null;
        output = formatter.format(date);
        return output;
    }

    public static String currentDate(String format) {
        SimpleDateFormat sdfDate = new SimpleDateFormat(format);//dd/MM/yyyy
        Date now = new Date();
        return sdfDate.format(now);
    }

    public static String currentDate()  {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
        Date now = new Date();
        return sdfDate.format(now);
    }

    public static Date stringToDate(String date,String format) throws ParseException {
        return new SimpleDateFormat(format).parse(date);
    }

    public static String stringToString(String sourceDate, String sourceFormat, String toFormat) throws ParseException {
        Date source = new SimpleDateFormat(sourceFormat).parse(sourceDate);
        return DateFormat.dateToString(source, toFormat);
    }

    public static Integer getYear(Date date) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy");
        Date now = new Date();
        String strDate = sdfDate.format(date);
        return Integer.valueOf(strDate);
    }

    public static Integer getDateNo(Date date) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd");
        String strDate = sdfDate.format(date);
        return Integer.valueOf(strDate);
    }

}
