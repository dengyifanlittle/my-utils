package com.littledyf.cqs;

import org.springframework.context.ApplicationContext;

/**
 * event  提供者
 * @param <H>
 */
public class EventProvider<H extends EventHandler<?>> {
    private final ApplicationContext applicationContext;
    private final Class<H> type;

    EventProvider(ApplicationContext applicationContext, Class<H> type) {
        this.applicationContext = applicationContext;
        this.type = type;
    }

    public H get() {
        return applicationContext.getBean(type);
    }
}