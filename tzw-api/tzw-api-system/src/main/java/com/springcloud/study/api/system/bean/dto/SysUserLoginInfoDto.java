package com.springcloud.study.api.system.bean.dto;

import com.springcloud.study.core.constant.CacheConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 类 描 述: 用户登录信息
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@Data
@NoArgsConstructor
public class SysUserLoginInfoDto implements Serializable {

    private static final long serialVersionUID = -2213354556554393217L;

    /**
     * 用户ID
     */
    private String id;

    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 登录时间
     */
    private Long loginTime;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地点
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
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;


    /**
     * 获取登录id
     */
    public String getLoginId() {
        return userType + CacheConstants.LOGINID_JOIN_CODE + id;
    }
}
