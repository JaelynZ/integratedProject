package com.jaelyn.integrated.module.limitflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 限流
 *
 * @author jingling.zhang@ucarinc.com
 * @date 2020/11/1 11:05
 **/
@Service
public class LimitFlow {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 限流
     * @param intervalTime 限流时间
     * @return
     */
    public String limitFlow(Long intervalTime){
        Long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
        if(redisTemplate.hasKey("limit")) {
            Integer count = redisTemplate.opsForZSet().rangeByScore("limit", currentTime -  intervalTime, currentTime).size();        // intervalTime是限流的时间
            System.out.println(count);
            if (count != null && count > 5) {
                return "每分钟最多只能访问5次";
            }
        }
        redisTemplate.opsForZSet().add("limit", UUID.randomUUID().toString(),currentTime);
        return "访问成功";
    }
}
