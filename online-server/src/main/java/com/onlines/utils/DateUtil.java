package com.onlines.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static String MMddHHmmDigit = "MM-dd HH:mm";
    public static String yyyyMM = "yyyyMM";

    public static String formatDate(Date date, String pattern) {
        if (null == date) {
            return "";
        }
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 获取当天0时0分0秒
     *
     * @param day 日期 yyyyMMdd
     * @return 返回时间字符串 yyyy-MM-dd HH:mm:ss
     */
    public static Date getDayStartDate(Integer day) {
        LocalDate localDate = LocalDate.of(day / 10000, day % 10000 / 100, day % 10000 % 100);
        LocalDateTime localDateTime = localDate.atStartOfDay();
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取当天23时59分59秒
     *
     * @param day 日期 yyyyMMdd
     * @return 返回时间字符串 yyyy-MM-dd HH:mm:ss
     */
    public static Date getDayEndDate(Integer day) {
        LocalDate localDate = LocalDate.of(day / 10000, day % 10000 / 100, day % 10000 % 100);
        LocalDateTime localDateTime = localDate.atTime(23, 59, 59);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    /**
     * 获取当前时间afterDay之后的时间
     *
     * @param afterDay
     * @return
     */
    public static Date getAfterDayDate(Date date, int afterDay) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, afterDay);
        return c.getTime();
    }

    public static Date getToday() {
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }

}
