package com.jaelyn.integrated.module.limitflow;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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

    //----------------------------------固定窗口限流-------------------------------------------------------

    /**
     * 固定窗口限流
     * 每分钟100个请求
     *
     * @return
     */
    public String fixedWindowLimitFlow() {
        long count = redisTemplate.opsForValue().decrement("fixed_limit");
        if (count <= 0) {
            return "限流了";
        }
        return "访问成功";
    }

    /**
     * 每分钟设置一次固定窗口
     */
    @Scheduled(fixedDelay = 60_000, initialDelay = 0)
    public void setFixedIntervalTimeTask() {
        redisTemplate.opsForValue().set("fixed_limit", 100, 1, TimeUnit.MINUTES);
    }


    //----------------------------------滑动窗口限流-------------------------------------------------------

    /**
     * 滑动窗口限流
     *
     * @param intervalTime 限流时间
     * @return
     */
    public String slideWindowLimitFlow(Long intervalTime) {
        Long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
        if (redisTemplate.hasKey("limit")) {
            Integer count = redisTemplate.opsForZSet().rangeByScore("limit", currentTime - intervalTime, currentTime).size();        // intervalTime是限流的时间
            System.out.println(count);
            if (count != null && count > 5) {
                return "每分钟最多只能访问5次";
            }
        }
        redisTemplate.opsForZSet().add("limit", UUID.randomUUID().toString(), currentTime);
        return "访问成功";
    }

    //----------------------------------令牌桶限流-------------------------------------------------------

    /**
     * 令牌桶限流
     *
     * @return
     */
    public String tokenBucketLimitFlow() {
        Object result = redisTemplate.opsForList().leftPop("limit_flow_list");
        if (result == null) {
            return "当前令牌桶中无令牌";
        }
        return "访问成功";
    }

    /**
     * 每秒添加100个令牌到令牌桶中
     */
    @Scheduled(fixedDelay = 1_000, initialDelay = 0)
    public void setIntervalTimeTask() {
        List<String> tokenList = Lists.newArrayList();
        String token = UUID.randomUUID().toString();
        for (int index = 0; index < 100; index++) {
            tokenList.add(token + "-" + index);
        }
        redisTemplate.opsForList().rightPushAll("limit_flow_list", tokenList);
    }
}
