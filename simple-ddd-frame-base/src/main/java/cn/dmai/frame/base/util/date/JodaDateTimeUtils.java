package cn.dmai.frame.base.util.date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * @Author linchengdong
 * @Date 2023-11-29 15:07
 * @PackageName:cn.dmai.frame.base.util.date
 * @ClassName: JodaDateTimeUtils
 * @Description: 时间工具类
 * @Version 1.0
 */
public class JodaDateTimeUtils {

    /**
     * 日期时间格式
     */
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 时间格式
     */
    public static final String TIME_FORMAT = "HH:mm:ss";


    /**
     * 将日期转换成字符串
     */
    public static String parseDateToString(Date date, String format) {
        return new DateTime(date).toString(format);
    }

    /**
     * 将字符串转换成日期
     */
    public static Date parseStringToDate(String date, String format) {
        return DateTimeFormat.forPattern(format).parseDateTime(date).toDate();
    }
}
