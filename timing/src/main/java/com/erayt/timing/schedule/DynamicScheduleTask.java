package com.erayt.timing.schedule;

import com.erayt.timing.repository.ScheduleMapper;
import com.erayt.timing.service.ImportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Auther: Z151
 * @Date: 2021/3/30 09:30
 */
@Slf4j
@Configuration
public class DynamicScheduleTask implements SchedulingConfigurer {

    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private ImportService importServiceImpl;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ////1.添加任务内容(Runnable) ////2.设置执行周期(Trigger)
        scheduledTaskRegistrar.addTriggerTask(
            //1.添加任务内容(Runnable)
                importServiceImpl
                ,
            //2.设置执行周期(Trigger)
            triggerContext -> {
                String cron = scheduleMapper.getCron();
                Date nextExecutionTime = new CronTrigger(cron).nextExecutionTime(triggerContext);
                return nextExecutionTime;
            }
            );
    }
}
