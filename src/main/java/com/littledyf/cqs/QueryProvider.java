package com.littledyf.cqs;

import org.springframework.context.ApplicationContext;

/**
 * query  提供者
 * @param <H>
 */
public class QueryProvider<H extends QueryHandler<?, ?>> {
    private final ApplicationContext applicationContext;
    private final Class<H> type;

    QueryProvider(ApplicationContext applicationContext, Class<H> type) {
        this.applicationContext = applicationContext;
        this.type = type;
    }

    public H get() {
        return applicationContext.getBean(type);
    }
}