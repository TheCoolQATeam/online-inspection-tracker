package com.onlines.job;

import com.onlines.controller.OnlinesSaleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class TriggerUrlJob implements InitializingBean {
    private static final Logger logger= LoggerFactory.getLogger(OnlinesSaleController.class);
    @Autowired
    private OnlinesSaleController onlinesSaleController;

    public void triggerUrlTask() {
        try {
            logger.info("开始执行 " + new Date());
            onlinesSaleController.invokerTestng();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.info("invokerTestng接口异常" + ex);
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
