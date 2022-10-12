package com.springcloud.study.log.annotation;

import com.springcloud.study.log.enums.BusinessType;
import com.springcloud.study.log.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 类 描 述: 自定义操作日志记录注解
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperLog {
    /**
     * 模块
     */
    String title() default "";

    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;
}
