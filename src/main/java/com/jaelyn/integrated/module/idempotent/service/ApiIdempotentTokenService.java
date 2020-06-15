package com.jaelyn.integrated.module.idempotent.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * api幂等token接口
 *
 * @author jingling.zhang@ucarinc.com
 * @date 2020-06-15 10:52
 **/
public interface ApiIdempotentTokenService {

    Map createToken();

    void checkToken(HttpServletRequest request);
}
