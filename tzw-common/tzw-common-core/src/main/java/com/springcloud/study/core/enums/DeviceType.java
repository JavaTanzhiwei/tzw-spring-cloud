package com.springcloud.study.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 类 描 述: 设备类型
 * 作   者: 谭志伟
 * 时   间: 2022/9/27  14:39
 */
@Getter
@AllArgsConstructor
public enum DeviceType {

    /**
     * pc端
     */
    PC("pc"),

    /**
     * app端
     */
    APP("app"),

    /**
     * 小程序端
     */
    XCX("xcx");

    private final String device;
}
