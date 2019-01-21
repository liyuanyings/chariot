package com.example.base.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {

    public final static String PATTERN_MINUTE     = "HH:mm";
    public static final String PATTERN_TIME       = "HH:mm:ss";
    public final static String PATTERN_MONTH      = "yyyy-MM";
    public static final String PATTERN_DATE       = "yyyy-MM-dd";
    public static final String PATTERN_DATETIME   = "yyyy-MM-dd HH:mm:ss";
    public static final String GMT8               = "GMT+8";
    public static final TimeZone TIME_ZONE_CHINA  = TimeZone.getTimeZone("GMT+:08:00");

    public static final int FIRST_DAY_OF_WEEK     = 1;

    public static Date dayBegin(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendarSetBegin(calendar).getTime();
    }

    public static Date dayBegin(int i){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, i);
        return calendarSetBegin(calendar).getTime();
    }

    public static Date dayBegin(Date date, int i) {
        if (date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, i);
        return calendarSetBegin(calendar).getTime();
    }

    public static Date dayEnd(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendarSetEnd(calendar).getTime();
    }

    public static Date dayEnd(int i){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, i);
        return calendarSetEnd(calendar).getTime();
    }

    public static Date dayEnd(Date date, int i){
        if (date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, i);
        return calendarSetEnd(calendar).getTime();
    }

    public static Date weekBegin(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if(FIRST_DAY_OF_WEEK == dayOfWeek){
            calendar.add(Calendar.DATE, -1);
        }
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMinimum(Calendar.DAY_OF_WEEK));
        calendar.add(Calendar.DATE, 1);
        return calendarSetBegin(calendar).getTime();
    }

    public static Date weekBegin(int i){
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if(FIRST_DAY_OF_WEEK == dayOfWeek){
            calendar.add(Calendar.DATE, -1);
        }
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMinimum(Calendar.DAY_OF_WEEK));
        calendar.add(Calendar.DATE, 7*i + 1);
        return calendarSetBegin(calendar).getTime();
    }

    public static Date weekBegin(Date date, int i){
        if (date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if(FIRST_DAY_OF_WEEK == dayOfWeek){
            calendar.add(Calendar.DATE, -1);
        }
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMinimum(Calendar.DAY_OF_WEEK));
        calendar.add(Calendar.DATE, 7*i + 1);
        return calendarSetBegin(calendar).getTime();
    }

    public static Date weekEnd(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if(FIRST_DAY_OF_WEEK == dayOfWeek){
            calendar.add(Calendar.DATE, -1);
        }
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMaximum(Calendar.DAY_OF_WEEK));
        calendar.add(Calendar.DATE, 1);
        return calendarSetEnd(calendar).getTime();
    }

    public static Date weekEnd(int i){
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if(FIRST_DAY_OF_WEEK == dayOfWeek){
            calendar.add(Calendar.DATE, -1);
        }
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMaximum(Calendar.DAY_OF_WEEK));
        calendar.add(Calendar.DATE, 7*i + 1);
        return calendarSetEnd(calendar).getTime();
    }

    public static Date weekEnd(Date date, int i){
        if (date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if(FIRST_DAY_OF_WEEK == dayOfWeek){
            calendar.add(Calendar.DATE, -1);
        }
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMaximum(Calendar.DAY_OF_WEEK));
        calendar.add(Calendar.DATE, 7*i + 1);
        return calendarSetEnd(calendar).getTime();
    }

    public static Date monthBegin(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendarSetBegin(calendar).getTime();
    }

    public static Date monthBegin(int i){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.MONTH, i);
        return calendarSetBegin(calendar).getTime();
    }

    public static Date monthBegin(Date date, int i){
        if(date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.MONTH, i);
        return calendarSetBegin(calendar).getTime();
    }

    public static Date monthEnd(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendarSetEnd(calendar).getTime();
    }

    public static Date monthEnd(int i){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
        calendar.add(Calendar.MONTH, i);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendarSetEnd(calendar).getTime();
    }

    public static Date monthEnd(Date date, int i){
        if (date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
        calendar.add(Calendar.MONTH, i);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendarSetEnd(calendar).getTime();
    }

    public static Date yearBegin(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMinimum(Calendar.DAY_OF_YEAR));
        return calendarSetBegin(calendar).getTime();
    }

    public static Date yearBegin(int i){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMinimum(Calendar.DAY_OF_YEAR));
        calendar.add(Calendar.YEAR, i);
        return calendarSetBegin(calendar).getTime();
    }

    public static Date yearBegin(Date date, int i){
        if(date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMinimum(Calendar.DAY_OF_YEAR));
        calendar.add(Calendar.YEAR, i);
        return calendarSetBegin(calendar).getTime();
    }

    public static Date yearEnd(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        return calendarSetEnd(calendar).getTime();
    }

    public static Date yearEnd(int i){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        calendar.add(Calendar.YEAR, i);
        return calendarSetEnd(calendar).getTime();
    }

    public static Date yearEnd(Date date, int i){
        if(date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        calendar.add(Calendar.YEAR, i);
        return calendarSetEnd(calendar).getTime();
    }

    public static Date parseDate(String text, String... parsePatterns) throws ParseException {
        return org.apache.commons.lang3.time.DateUtils.parseDate(text, parsePatterns);
    }

    public static String formatDate(Date date, String pattern){
        return DateFormatUtils.format(date, pattern, TIME_ZONE_CHINA, Locale.CHINA);
    }

    private static Calendar calendarSetBegin(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    private static Calendar calendarSetEnd(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar;
    }

    public static void main(String[] args){

//        System.out.println("date begin: " + dayBegin(new Date()));
//        System.out.println("date begin: " + dayBegin(5));
//        System.out.println("date begin: " + dayBegin(new Date(), 0));
//
//        System.out.println("date end: " + dayEnd(new Date()));
//        System.out.println("date end: " + dayEnd(0));
//        System.out.println("date end: " + dayEnd(new Date(), 0));
//
        Date day = dayBegin(5);
        int i = -1;
        System.out.println("week begin: " + weekBegin( day ));
        System.out.println("week begin: " + weekBegin(i));
        System.out.println("week begin: " + weekBegin(day, i));

        System.out.println("week end: " + weekEnd( day ));
        System.out.println("week end: " + weekEnd(i));
        System.out.println("week end: " + weekEnd( day, i));

//        System.out.println("month begin: " + monthBegin(new Date()));
//        System.out.println("month begin: " + monthBegin(-1));
//        System.out.println("month begin: " + monthBegin(new Date(), 0));
//
//        System.out.println("month end: " + monthEnd(new Date()));
//        System.out.println("month end: " + monthEnd(1));
//        System.out.println("month end: " + monthEnd(new Date(), 0));

//        System.out.println("year begin: " + yearBegin(new Date()));
//        System.out.println("year begin: " + yearBegin(-1));
//        System.out.println("year begin: " + yearBegin(new Date(), 0));
//
//        System.out.println("year end: " + yearEnd(new Date()));
//        System.out.println("year end: " + yearEnd(1));
//        System.out.println("year end: " + yearEnd(new Date(), 0));
    }
}

