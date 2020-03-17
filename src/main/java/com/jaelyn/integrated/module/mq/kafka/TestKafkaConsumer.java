package com.jaelyn.integrated.module.mq.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author jaelynz@gamil.com
 * @date 2020-03-17 16:17
 **/
@Component
@Slf4j
public class TestKafkaConsumer {
    @KafkaListener(topics = {"test"})
    public void receiveMessage(String message) {
        //收到通道的消息之后执行秒杀操作
        log.info("接收到消息：{}", message);
    }
}
