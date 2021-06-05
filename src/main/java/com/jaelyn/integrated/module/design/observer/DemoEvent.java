package com.jaelyn.integrated.module.design.observer;

import org.springframework.context.ApplicationEvent;

/**
 * TODO
 *
 * @author zjaelyn@gmail.com
 * @date 2020/12/1 18:08
 **/
public class DemoEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;

    private String message;

    public DemoEvent(Object source,String message){
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
