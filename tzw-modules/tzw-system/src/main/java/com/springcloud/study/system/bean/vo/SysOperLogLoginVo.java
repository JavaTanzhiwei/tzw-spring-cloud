package com.springcloud.study.system.bean.vo;

import lombok.Data;

import java.util.Date;

/**
 * 类 描 述: 用户登录日志记录表 Req
 * 作   者: 谭志伟
 * 时   间: 2022/9/21  13:38
 */
@Data
public class SysOperLogLoginVo {
    /**
     * 日志主键
     */
    private String id;
    /**
     * 用户账号
     */
    private String loginName;
    /**
     * 登录状态(0=成功,1=失败)
     */
    private Integer status;
    /**
     * 登录地址
     */
    private String ipaddr;
    /**
     * 登录地点
     */
    private String loginLocation;
    /**
     * 浏览器
     */
    private String browser;
    /**
     * 操作系统
     */
    private String os;
    /**
     * 提示消息
     */
    private String msg;
    /**
     * 访问时间
     */
    private Date loginTime;
}
