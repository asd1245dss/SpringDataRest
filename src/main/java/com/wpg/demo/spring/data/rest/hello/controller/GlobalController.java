package com.wpg.demo.spring.data.rest.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Global controller
 * Created by Administrator on 2016/7/29.
 */
@RestController
public class GlobalController {

    private final StringRedisTemplate redisTemplate;


    @Autowired
    public GlobalController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @RequestMapping("/test")
    public String get() {
        redisTemplate.opsForValue().set("test", UUID.randomUUID().toString());
        return "successfully";
    }
}
