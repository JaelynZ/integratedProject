package com.jaelyn.integrated.module.distributedlock.controller;

import com.jaelyn.integrated.module.distributedlock.utils.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

/**
 * redis锁测试
 *
 * @author zjaelyn@gmail.com
 * @date 2020-01-13 15:55
 */
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {

    private static final String PRODUCT_KEY = "productKey";

    private static final String LOCK_KEY = "redisLock";

    @Autowired
    private RedisLock redisLock;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping("/lock")
    public void lockTest() throws InterruptedException {
        // 用户唯一标识
        String lockValue = UUID.randomUUID().toString().replace("-", "");
        Random random = new Random();
        int sleepTime;
        while (true) {
            if (redisLock.tryLock(LOCK_KEY, lockValue)) {
                log.info("[{}]成功获取锁", lockValue);
                break;
            }
            sleepTime = random.nextInt(1000);
            Thread.sleep(sleepTime);
            log.info("[{}]获取锁失败，{}毫秒后重新尝试获取锁", lockValue, sleepTime);
        }
        // 剩余库存
        String products = stringRedisTemplate.opsForValue().get(PRODUCT_KEY);
        if (products == null) {
            log.info("[{}]获取剩余库存失败，释放锁：{} @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@", lockValue, redisLock.unLock(LOCK_KEY, lockValue));
            return;
        }
        int surplus = Integer.parseInt(products);
        if (surplus <= 0) {
            log.info("[{}]库存不足，释放锁：{} ##########################################", lockValue, redisLock.unLock(LOCK_KEY, lockValue));
            return;
        }

        log.info("[{}]当前库存[{}]，操作：库存-1", lockValue, surplus);
        stringRedisTemplate.opsForValue().decrement(PRODUCT_KEY);
        log.info("[{}]操作完成，开始释放锁，释放结果：{}", lockValue, redisLock.unLock(LOCK_KEY, lockValue));
    }
}
