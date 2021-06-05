package com.jaelyn.integrated.module.design.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 订阅者模式-发布者
 *
 * @author zjaelyn@gmail.com
 * @date 2020/12/1 18:02
 **/
@Component
@Slf4j
public class DemoEventPublisher implements ApplicationEventPublisher {
    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void publishEvent(Object var1) {
        //发布事件
        applicationContext.publishEvent(new DemoEvent(this, var1.toString()));
    }
}
