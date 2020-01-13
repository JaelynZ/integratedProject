package com.jaelyn.integrated.common.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * Redis分布式锁
 *
 * @author zjaelyn@gmail.com
 * @date 2020-01-13 15:55
 */
@Component
public class RedisLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 加锁
     *
     * @param key   指定锁
     * @param value 用户唯一标识，用于释放锁是校验是否是加锁客户端
     */
    public boolean tryLock(String key, String value) {
        /*
         * 如果这个key存在则返回 false，
         * 不存在的，设置这个key，设置过期时间，返回true
         * 调用 set k v ex 5 nx 命令 (ex表示单位为秒，px表示单位是毫秒)
         */
        Boolean isLocked = stringRedisTemplate.opsForValue().setIfAbsent(key, value, 5, TimeUnit.SECONDS);
        if (isLocked == null) {
            return false;
        }
        return isLocked;
    }

    /**
     * 解锁
     */
    public Boolean unLock(String key, String value) {
        // 执行 lua 脚本
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        // 指定 lua 脚本
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("redis/unLock.lua")));
        // 指定返回类型
        redisScript.setResultType(Long.class);
        // 参数一：redisScript，参数二：key列表，参数三：arg（可多个）
        Long result = stringRedisTemplate.execute(redisScript, Collections.singletonList(key), value);
        return result != null && result > 0;
    }

}
