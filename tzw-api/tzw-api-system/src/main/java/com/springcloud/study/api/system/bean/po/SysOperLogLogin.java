package com.springcloud.study.api.system.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 类 描 述: 访问日志记录表 sys_oper_log_login
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@Data
@NoArgsConstructor
@TableName("sys_oper_log_login")
public class SysOperLogLogin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
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
