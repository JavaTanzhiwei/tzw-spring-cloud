package com.springcloud.study.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 类 描 述: OpenFeign 自定义注解
 * 作   者: 谭志伟
 * 时   间: 2022/9/21  14:18
 * @author tanzhiwei
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
public @interface EnableFeignTzwClients {
    String[] value() default {};

    String[] basePackages() default {"com.springcloud.study"};

    Class<?>[] basePackageClasses() default {};

    Class<?>[] defaultConfiguration() default {};

    Class<?>[] clients() default {};
}
