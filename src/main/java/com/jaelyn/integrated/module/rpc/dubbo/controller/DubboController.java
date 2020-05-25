package com.jaelyn.integrated.module.rpc.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jaelyn.integrated.module.rpc.dubbo.service.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author jaelynz@gamil.com
 * @date 2020-05-25 13:33
 **/
@RestController
@RequestMapping("/dubbo")
public class DubboController {
    @Reference(version = "1.0.0")
    private DubboService dubboService;

    @GetMapping("/sayHello")
    public String sayHello(String name) {
        return dubboService.sayHello(name);
    }
}
