package com.springcloud.study.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 类 描 述: 登录类型
 * 作   者: 谭志伟
 * 时   间: 2022/9/27  16:10
 */
@Getter
@AllArgsConstructor
public enum LoginType {
    /**
     * 密码登录
     */
    PASSWORD("user.password.retry.limit.exceed", "user.password.retry.limit.count"),

    /**
     * 短信登录
     */
    SMS("sms.code.retry.limit.exceed", "sms.code.retry.limit.count"),

    /**
     * 小程序登录
     */
    XCX("", "");

    /**
     * 登录重试超出限制提示
     */
    final String retryLimitExceed;

    /**
     * 登录重试限制计数提示
     */
    final String retryLimitCount;
}
