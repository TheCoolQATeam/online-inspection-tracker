package com.onlines.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
    @Scheduled(cron="0/5****?")
    public void  task(){
        System.out.println("***********task执行中****");
    }
}
