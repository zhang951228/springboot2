package com.erayt.timing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling //2.开启定时任务
@SpringBootApplication
public class TimingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimingApplication.class, args);
    }

}
