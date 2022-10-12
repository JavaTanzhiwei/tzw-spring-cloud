package com.springcloud.study.api.system.bean.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 类 描 述: 当前在线会话
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:18
 */
@Data
@NoArgsConstructor
public class SysUserOnlineDto implements Serializable {
    private static final long serialVersionUID = -4367940940351107784L;

    /**
     * 会话编号
     */
    private String tokenId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地址
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 登录时间
     */
    private Long loginTime;
}
