package com.littledyf.cache.redis.service;

import com.littledyf.cache.redis.MyCacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheServiceImpl {

    @MyCacheable(expire = "60", invoker = "my-test")
    public String testRedisCache(String value) {
        System.err.println("testRedisCache");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 模拟业务逻辑处理
        return value;
    }
}
