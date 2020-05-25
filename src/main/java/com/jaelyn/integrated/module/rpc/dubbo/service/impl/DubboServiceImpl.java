package com.jaelyn.integrated.module.rpc.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jaelyn.integrated.module.rpc.dubbo.service.DubboService;

/**
 * TODO
 *
 * @author jaelynz@gamil.com
 * @date 2020-05-25 11:31
 **/
@Service(version = "1.0.0")
public class DubboServiceImpl implements DubboService {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
