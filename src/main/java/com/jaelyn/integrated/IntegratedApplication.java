package com.jaelyn.integrated;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 *
 * @author zjaelyn@gmail.com
 * @date 2020-01-13 15:56
 */
@SpringBootApplication
@MapperScan("com.jaelyn.integrated.module.**.dao")
public class IntegratedApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegratedApplication.class, args);
    }

}
