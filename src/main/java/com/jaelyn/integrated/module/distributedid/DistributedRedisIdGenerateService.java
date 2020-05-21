package com.jaelyn.integrated.module.distributedid;

import com.jaelyn.integrated.common.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis实现分布式ID生成
 *
 * @author jaelynz@gamil.com
 * @date 2020-05-20 17:23
 **/
@Component
@Slf4j
public class DistributedRedisIdGenerateService {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RedisTemplate redisTemplate;




}
