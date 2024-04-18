package com.littledyf.cqs;

import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 注册器
 */
public class Registry {

    /**
     * Query对象和命令提供者的对应关系
     */
    private Map<Class<? extends Query>,QueryProvider> queryProviderMap =  new HashMap<>();

    /**
     * Event对象和命令提供者的对应关系
     */
    private Map<Class<? extends Event>,EventProvider> eventProviderMap =  new HashMap<>();

    public Registry(ApplicationContext applicationContext){
        String[] names = applicationContext.getBeanNamesForType(QueryHandler.class);
        for (String name : names) {
            registerQuery(applicationContext,name);
        }
        names = applicationContext.getBeanNamesForType(EventHandler.class);
        for (String name : names) {
            registerEvent(applicationContext,name);
        }
    }

    private void registerQuery(ApplicationContext applicationContext, String name) {
        Class<QueryHandler<?,?>> handlerClass = (Class<QueryHandler<?,?>>) applicationContext.getType(name);
        Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(handlerClass, QueryHandler.class);
        Class<? extends Query> queryType  = (Class<? extends Query>) generics[1];
        queryProviderMap.put(queryType, new QueryProvider(applicationContext, handlerClass));
    }

    private void registerEvent(ApplicationContext applicationContext, String name) {
        Class<EventHandler<?>> handlerClass = (    Class<EventHandler<?>>) applicationContext.getType(name);
        Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(handlerClass, EventHandler.class);
        Class<? extends Event> eventType  = (Class<? extends Event>) generics[0];
        eventProviderMap.put(eventType, new EventProvider(applicationContext, handlerClass));
    }

    /**
     * 获取具体的QueryHandler   <R, Q extends Query<R>>定义R  Q的类型
     * @param queryClass
     * @param <R>
     * @param <Q>
     * @return
     */
    <R, Q extends Query<R>> QueryHandler<R,Q> getQuery(Class<Q> queryClass) {
        return queryProviderMap.get(queryClass).get();
    }

    /**
     * 获取具体的EventHandler
     * @param eventClass
     * @return
     */
    <E extends Event> EventHandler<E> getEvent(Class<? extends Event> eventClass) {
        return eventProviderMap.get(eventClass).get();
    }
}

