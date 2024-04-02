package com.onlines.job;

import com.onlines.controller.OnlinesSaleController;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class TriggerUrlJob implements InitializingBean {
    @Autowired
    private OnlinesSaleController onlinesSaleController;

    public void triggerUrlTask() {
        try {
            System.out.println("开始执行 " + new Date());
            onlinesSaleController.invokerTestng();
        } catch (Exception ex) {
            System.out.println("invokerTestng接口异常" + ex);
        }

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 参数：1、任务体 2、首次执行的延时时间
        //      3、任务执行间隔 4、间隔时间单位
        service.scheduleAtFixedRate(() -> triggerUrlTask(), 1, 5, TimeUnit.MINUTES);
    }
}
