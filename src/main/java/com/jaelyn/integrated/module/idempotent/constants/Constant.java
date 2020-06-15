package com.jaelyn.integrated.module.idempotent.constants;

/**
 * 幂等常量
 *
 * @author jingling.zhang@ucarinc.com
 * @date 2020-06-15 10:51
 **/
public class Constant {

    public interface Redis {
        String OK = "OK";
        Integer EXPIRE_TIME_MINUTE = 60;// 过期时间, 60s, 一分钟
        Integer EXPIRE_TIME_FIVE_MINUTE = 5 * 60;// 过期时间, 60s, 一分钟
        Integer EXPIRE_TIME_HOUR = 60 * 60;// 过期时间, 一小时
        Integer EXPIRE_TIME_DAY = 60 * 60 * 24;// 过期时间, 一天
        String TOKEN_PREFIX = "API_IDEMPOTENT_TOKEN:";
    }
}
