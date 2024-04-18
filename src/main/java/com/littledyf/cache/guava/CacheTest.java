package com.littledyf.cache.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {
    private static final RemovalListener<String,String> listener = notification -> System.err.println("remove key:" + notification.getKey());


    private static Cache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(10)
            .expireAfterWrite(2, TimeUnit.SECONDS)
            .removalListener(listener)
            .build();


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        cache.put("a", "A");
        System.out.println("cache key a value:" + cache.getIfPresent("a"));
        Thread.sleep(3000);
        //填充值
        cache.put("b", "B");
        System.out.println("put后cache.getIfPresent(b)：" + cache.getIfPresent("b"));
    }
}

