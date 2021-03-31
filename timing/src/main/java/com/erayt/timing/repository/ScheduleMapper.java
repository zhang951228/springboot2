package com.erayt.timing.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: Z151
 * @Date: 2021/3/30 09:29
 */
@Mapper
public interface ScheduleMapper {

    /**
     * 获取定时任务时间间隔cron表达式。
     */
    @Select("select cron from cron")
    String getCron();
}
