package com.jaelyn.integrated;

import com.jaelyn.integrated.module.design.observer.DemoEventPublisher;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.locks.ReentrantLock;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = IntegratedApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles(value = "dev")
class IntegratedApplicationTests {
    @Autowired
    private DemoEventPublisher demoEventPublisher;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testObserverDemo() {
        System.out.println("123");
        //demoEventPublisher.publishEvent("jaelyn");
    }

    @Test
    void test() {
        redisTemplate.opsForValue().set("test","ahah");
        System.out.println(redisTemplate.opsForValue().get("test"));
        //redisTemplate.

        ReentrantLock lock = new ReentrantLock(true);
        ThreadLocal threadLocal = new ThreadLocal();
    }

}
