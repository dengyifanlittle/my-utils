package com.littledyf.cache.guava;

import com.google.common.cache.*;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class LoadingCacheTest {

    private static final RemovalListener<String,String> listener = notification -> System.err.println("remove key:" + notification.getKey());

    private static LoadingCache<String, String> loadingCache = CacheBuilder
            .newBuilder()
            .maximumSize(5)
            .removalListener(listener)
            .expireAfterWrite(2,TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) {
                    return key.toUpperCase(Locale.ROOT);
                }
            });

    public static void main(String[] args) throws Exception {
        System.out.println("a的缓存：" + loadingCache.get("a"));
        System.out.println("b的缓存：" + loadingCache.get("b"));
        Thread.sleep(4000);
        loadingCache.put("c", "C");
        System.out.println("c的缓存：" + loadingCache.get("c"));
    }

}
