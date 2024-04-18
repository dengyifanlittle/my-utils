package com.littledyf.cache.redis.controller;

import com.littledyf.cache.redis.service.RedisCacheServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/my-test/redis-cache")
public class RedisCacheController {

    private final RedisCacheServiceImpl redisCacheService;

    public RedisCacheController(RedisCacheServiceImpl redisCacheService) {
        this.redisCacheService = redisCacheService;
    }


    @GetMapping(value = "/test/{value}")
    public String testRedisCache(@PathVariable("value")  String value)  {
        return redisCacheService.testRedisCache(value);
    }
}
