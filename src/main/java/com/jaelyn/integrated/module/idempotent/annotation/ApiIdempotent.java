package com.jaelyn.integrated.module.idempotent.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 接口幂等注解
 *
 * @author jingling.zhang@ucarinc.com
 * @date 2020-06-15 10:49
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiIdempotent {

}
