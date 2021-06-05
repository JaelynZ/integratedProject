package com.jaelyn.integrated.module.spring;

import com.alibaba.fastjson.JSON;
import com.jaelyn.integrated.module.algorithm.ringcentral.Utils;
import com.jaelyn.integrated.module.set.Set;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * TODO
 *
 * @author jingling.zhang@ucarinc.com
 * @date 2020/11/13 11:28
 **/
public class SpringTest {
    public static void main(String[] args) throws Exception {
        //创建一个简单注册器
        /*BeanDefinitionRegistry register = new SimpleBeanDefinitionRegistry();
        //创建bean定义读取器
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(register);
        // 创建资源读取器
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        // 获取资源
        Resource xmlResource = resourceLoader.getResource("spring.xml");
        // 装载Bean的定义
        reader.loadBeanDefinitions(xmlResource);
        // 打印构建的Bean 名称
        System.out.println(Arrays.toString(register.getBeanDefinitionNames()));

        //ClassUtils.forName()
        */
        char a  = '1';

    }
}
