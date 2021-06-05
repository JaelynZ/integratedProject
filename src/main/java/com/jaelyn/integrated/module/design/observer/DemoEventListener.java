package com.jaelyn.integrated.module.design.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 订阅者模式-监听者
 *
 * @author zjaelyn@gmail.com
 * @date 2020/12/1 17:58
 **/
@Component
@Slf4j
public class DemoEventListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMessage();
        System.out.println("接收到的信息是：" + msg);
    }
}
