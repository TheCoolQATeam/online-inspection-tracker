package com.onlines.onlineSaleTest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringWrapper implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setContext(applicationContext);
    }

    private static void setContext(ApplicationContext context) {
        SpringWrapper.context = context;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static <T> T getBean(Class<T> type) throws BeansException {
        return context.getBean(type);
    }

    public static Object getBean(String name) throws BeansException {
        return context.getBean(name);
    }
}
