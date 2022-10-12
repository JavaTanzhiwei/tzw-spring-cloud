package com.springcloud.study.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 类 描 述: 用户状态
 * 作   者: 谭志伟
 * 时   间: 2022/9/27  19:14
 */
@Getter
@AllArgsConstructor
public enum UserStatus {
    /**
     * 属性描述: 用户状态
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 14:03
     */
    OK("0", "正常"),
    DISABLE("1", "停用"),
    DELETED("2", "删除");

    private final String code;
    private final String info;
}
