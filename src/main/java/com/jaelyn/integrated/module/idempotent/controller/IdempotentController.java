package com.jaelyn.integrated.module.idempotent.controller;

import com.google.common.collect.Maps;
import com.jaelyn.integrated.module.idempotent.annotation.ApiIdempotent;
import com.jaelyn.integrated.module.idempotent.service.ApiIdempotentTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 幂等控制层
 *
 * @author jaelynz@gamil.com
 * @date 2020-06-15 11:08
 **/
@RestController
@RequestMapping("/idempotent")
public class IdempotentController {
    @Autowired
    private ApiIdempotentTokenService apiIdempotentTokenService;

    /**
     * 获取token
     *
     * @return
     */
    @RequestMapping("/getToken")
    public Map getToken() {
        return apiIdempotentTokenService.createToken();
    }

    /**
     * 测试接口幂等性, 在需要幂等性校验的方法上声明此注解即可
     *
     * @return
     */
    @ApiIdempotent
    @RequestMapping("testIdempotence")
    public Map testIdempotence() {
        Map<String, Object> result = Maps.newHashMap();
        result.put("success", true);
        return result;
    }

}
