package com.jaelyn.integrated.module.idempotent.config;

import com.jaelyn.integrated.module.idempotent.annotation.ApiIdempotent;
import com.jaelyn.integrated.module.idempotent.service.ApiIdempotentTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * api幂等拦截器
 *
 * @author jingling.zhang@ucarinc.com
 * @date 2020-06-15 11:06
 **/
@Component
public class ApiIdempotentInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ApiIdempotentTokenService apiIdempotentTokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        ApiIdempotent methodAnnotation = method.getAnnotation(ApiIdempotent.class);
        if (methodAnnotation != null) {
            check(request);
        }

        return true;
    }

    private void check(HttpServletRequest request) {
        apiIdempotentTokenService.checkToken(request);
    }
}
