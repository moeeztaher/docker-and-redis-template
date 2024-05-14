package com.cloudcomputing.cloudcomputing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String REDIS_KEY = "visits";

    @GetMapping("/")
    public String handleRequest() {
        Long visits = redisTemplate.opsForValue().increment(REDIS_KEY, 1);
        return "Total visits: " + visits;
    }
}
