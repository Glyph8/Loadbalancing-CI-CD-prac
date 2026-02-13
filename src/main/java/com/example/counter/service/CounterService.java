package com.example.counter.service;

import lombok.Data;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Data
public class CounterService {
    private final StringRedisTemplate redisTemplate;
    private static final String COUNTER_KEY = "visit:count";

    public Long increment(){
        return redisTemplate.opsForValue().increment(COUNTER_KEY);
        // 이게 무슨 문법인가?
        // 생각보다 opsFor~ 종류가 5개가 넘는데?
    }

    public Long getCount(){
        String count = redisTemplate.opsForValue().get(COUNTER_KEY);
        return count == null ? 0L : Long.parseLong(count);
    }

}
