package com.erayt.single.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * @Auther: Z151
 * @Date: 2021/3/19 15:36
 */
public class DateUtil {
    private static DateTimeFormatter fmDate = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     * 获取日期字符串
     * @return 8位日期字符串
     */
    public static String getDate(){
        LocalDate today = LocalDate.now();
        return today.format(fmDate);
    }

    /**
     * 获取包含日期、时间戳、随机UUID的长字符串。
     * @return  八位日期字符串_时间戳_UUID
     */
    public static String getDateRandom(){
        LocalDate today = LocalDate.now();
        long timeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder(60);
        stringBuilder.append('_')
            .append(today.format(fmDate))
            .append('_')
            .append(timeMillis)
            .append('_')
            .append(RandomUtil.getUUID32());
        return stringBuilder.toString();
    }
}
