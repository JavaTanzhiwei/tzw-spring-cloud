package com.springcloud.study.core.exception.user;

import com.springcloud.study.core.exception.base.BaseException;

/**
 * 类 描 述: 用户信息异常类
 * 作   者: 谭志伟
 * 时   间: 2022/9/27  16:14
 */
public class UserException extends BaseException {
    public UserException(String code, Object... args) {
        super("user", code, args, null);
    }
}
