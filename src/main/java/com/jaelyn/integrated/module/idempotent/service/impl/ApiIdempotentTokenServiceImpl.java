package com.jaelyn.integrated.module.idempotent.service.impl;

import com.google.common.collect.Maps;
import com.jaelyn.integrated.common.utils.RedisUtil;
import com.jaelyn.integrated.module.idempotent.constants.Constant;
import com.jaelyn.integrated.module.idempotent.enums.ResponseCode;
import com.jaelyn.integrated.module.idempotent.service.ApiIdempotentTokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

/**
 * api幂等token接口实现类
 *
 * @author jaelynz@gamil.com
 * @date 2020-06-15 10:54
 **/
@Service
public class ApiIdempotentTokenServiceImpl implements ApiIdempotentTokenService {

    private static final String API_IDEMPOTENT_TOKEN_NAME = "apiIdempotentToken";

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Map createToken() {
        String str = UUID.randomUUID().toString();
        StringBuilder token = new StringBuilder();
        token.append(Constant.Redis.TOKEN_PREFIX).append(str);
        redisUtil.set(token.toString(), token.toString(), Constant.Redis.EXPIRE_TIME_FIVE_MINUTE);
        Map<String, Object> result = Maps.newHashMap();
        result.put("success", true);
        result.put("token", token.toString());
        return result;
    }

    @Override
    public void checkToken(HttpServletRequest request) {
        String token = request.getHeader(API_IDEMPOTENT_TOKEN_NAME);
        // header中不存在token
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(API_IDEMPOTENT_TOKEN_NAME);
            // parameter中也不存在token
            if (StringUtils.isBlank(token)) {
                throw new RuntimeException (ResponseCode.ILLEGAL_ARGUMENT.getMsg());
            }
        }

        if (!redisUtil.exists(token)) {
            throw new RuntimeException (ResponseCode.REPETITIVE_OPERATION.getMsg());
        }

        Boolean del = redisUtil.del(token);
        if (!del) {
            throw new RuntimeException (ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
    }
}
