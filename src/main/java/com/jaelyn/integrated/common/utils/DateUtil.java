package com.jaelyn.integrated.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类
 *
 * @author zjaelyn@gmail.cominc.com
 * @date 2020-03-06 16:35
 */
@Slf4j
public class DateUtil {

    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String NULL = "null";
    public static final String YYYYMMDDZERO = "yyyy-MM-dd 00:00:00";
    public static final String YYYYMMDDMAX = "yyyy-MM-dd 23:59:59";

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public static String timeStampToDate(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals(NULL)) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param date   字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String dateToTimeStamp(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 取得当前时间戳（精确到秒）
     *
     * @return
     */
    public static String timeStamp() {
        long time = System.currentTimeMillis();
        String t = String.valueOf(time / 1000);
        return t;
    }

    /**
     * 时间格式化字符串（默认格式yyyy-MM-dd HH:mm:ss）
     *
     * @param date
     * @return
     */
    public static String timeToString(Date date) {
        return dateToString(date, YYYYMMDDHHMMSS);
    }

    /**
     * 日期格式化字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format) {
        if (date == null || StringUtils.isBlank(format)) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 字符串转换为时间格式
     * 当转换异常或者字符串格式时间为空时，返回null
     *
     * @param dateStr 字符串格式时间
     * @param format  转换格式
     * @return java.util.Date
     * @author zjaelyn@gmail.com
     * @date 2019-10-26 14:35
     */
    public static Date stringToDate(String dateStr, String format) {
        try {
            if (StringUtils.isEmpty(dateStr)) {
                return null;
            }
            return new SimpleDateFormat(format).parse(dateStr);
        } catch (Exception e) {
            log.error(">>>>>字符串转换为时间格式异常(stringToDate is fail)，异常信息是{}是，时间字符串{},格式{}<<<<<<", LogUtil.printStackTrace(e), dateStr, format);
            return null;
        }
    }

    /**
     * 字符串日期转换成字符串日期
     *
     * @param date 字符串日期
     * @return
     * @throws Exception
     */
    public static String dateFormatToString(String date) {
        if (StringUtils.isEmpty(date)) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = "";
        try {
            formatDate = formatter.format(formatter.parse(date));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return formatDate;
    }

    /**
     * 比较两个日期大小 <br>
     *
     * @param startDate 起始日期
     * @param endDate   截止日期
     * @return "boolean"  如果startDate > endDate, 返回true
     * @author zjaelyn@gmail.com
     * @date 2019-10-19 15:58
     */
    public static boolean compareTo(Date startDate, Date endDate) {
        return startDate.compareTo(endDate) > 0;
    }

    /**
     * 指定日期添加天数 <br>
     *
     * @param newDate 指定日期
     * @param num     添加天数
     * @return "java.lang.String"
     * @author zjaelyn@gmail.com
     * @date 2019-10-30 21:43
     */
    public static String plusDay(String newDate, int num) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(YYYYMMDDHHMMSS);
        Date currdate = format.parse(newDate);
        Calendar ca = Calendar.getInstance();
        ca.setTime(currdate);
        // num为增加的天数，可以改变的
        ca.add(Calendar.DATE, num);
        currdate = ca.getTime();
        return format.format(currdate);
    }

    /**
     * 指定日期添加天数 <br>
     *
     * @param newDate 指定日期
     * @param num     添加天数
     * @return "java.lang.String"
     * @author zjaelyn@gmail.com
     * @date 2019-10-30 21:43
     */
    public static Date plusDay(Date newDate, int num) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(newDate);
        ca.add(Calendar.DATE, num);
        return ca.getTime();
    }

    /**
     * 获取两个日期之间相差多少天 <br>
     *
     * @param start 起始
     * @param end   截止
     * @return "int"
     * @author zjaelyn@gmail.com
     * @date 2019-11-07 10:08
     */
    public static int differentDays(Date start, Date end) {
        int days = (int) ((end.getTime() - start.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    /**
     * 获取两个日期之间相差多少天 <br>
     *
     * @param startStr 起始
     * @param endStr   截止
     * @return "int"
     * @author zjaelyn@gmail.com
     * @date 2019-11-07 10:08
     */
    public static int differentDays(String startStr, String endStr, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date start = sdf.parse(startStr);
        Date end = sdf.parse(endStr);
        int days = (int) ((end.getTime() - start.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    /**
     * 获取两个日期之间相差多少天 <br>
     *
     * @param startStr 起始
     * @param endStr   截止
     * @return "int"
     * @author zjaelyn@gmail.com
     * @date 2019-11-07 10:08
     */
    public static int differentDays(String startStr, String endStr) throws ParseException {
        return differentDays(startStr, endStr, YYYYMMDD);
    }

    /**
     * 判断是否同一个月份 日期格式为 yyyy-MM-dd 的字符串<br>
     *
     * @param startStr 起始
     * @param endStr   截止
     * @return "boolean"
     * @author zjaelyn@gmail.com
     * @date 2019-11-07 19:21
     */
    public static boolean isSameMonth(String startStr, String endStr) {
        if (StringUtils.isNotEmpty(startStr) && StringUtils.isNotEmpty(endStr)) {
            Calendar startCal = Calendar.getInstance();
            startCal.setTime(DateUtil.stringToDate(startStr, DateUtil.YYYYMMDD));
            Calendar endCal = Calendar.getInstance();
            endCal.setTime(DateUtil.stringToDate(endStr, DateUtil.YYYYMMDD));
            String startYearMonth = startCal.get(Calendar.YEAR) + "-" + startCal.get(Calendar.MONTH);
            String endYearMonth = endCal.get(Calendar.YEAR) + "-" + endCal.get(Calendar.MONTH);
            return startYearMonth.equals(endYearMonth);
        }
        return false;
    }


    /**
     * 获取n天前的时间
     * 当异常时返回null
     *
     * @param date 时间
     * @param day  天数
     * @return java.lang.String
     * @author shaokai.zhang
     * @date 2019-11-11 17:47
     */
    public static String getDateBefore(Date date, int day) {
        try {
            Calendar no = Calendar.getInstance();
            no.setTime(date);
            no.set(Calendar.DATE, no.get(Calendar.DATE) - day);
            return DateUtil.dateToString(no.getTime(), DateUtil.YYYYMMDDHHMMSS);
        } catch (Exception e) {
            log.error(">>>>>>获取n天前时间异常，异常信息{},时间{},天数{}<<<<<<", LogUtil.printStackTrace(e), date, day);
        }
        return null;
    }


}
