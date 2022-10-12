package com.springcloud.study.log.factory;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.springcloud.study.api.system.bean.po.SysOperLogLogin;
import com.springcloud.study.core.constant.Constants;
import com.springcloud.study.core.utils.ServletUtils;
import com.springcloud.study.core.utils.ip.AddressUtils;
import com.springcloud.study.core.utils.spring.SpringContextHolder;
import com.springcloud.study.log.event.SysOperLogLoginEvent;

import java.util.Date;

/**
 * 类 描 述: 访问日志事件监听
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
public class SysUserLoginFactory {

    /**
     * 记录登陆信息
     *
     * @param username 用户名
     * @param status   状态
     * @param message  消息
     * @param args     列表
     */
    public static void recordLogininfor(final String username, final String status, final String message,
                                        final Object... args) {
        UserAgent userAgent = UserAgentUtil.parse(ServletUtils.getRequest().getHeader("User-Agent"));
        String ip = ServletUtils.getClientIP();
        // 封装对象
        SysOperLogLogin operLogLogin = new SysOperLogLogin();
        operLogLogin.setIpaddr(ip);
        operLogLogin.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
        operLogLogin.setBrowser(userAgent.getBrowser().getName());
        operLogLogin.setOs(userAgent.getOs().getName());
        operLogLogin.setLoginTime(new Date());
        operLogLogin.setLoginName(username);
        operLogLogin.setMsg(message);
        // 日志状态
        if (Constants.LOGIN_SUCCESS.equals(status) || Constants.LOGOUT.equals(status)) {
            operLogLogin.setStatus(Constants.SUCCESS);
        } else if (Constants.LOGIN_FAIL.equals(status)) {
            operLogLogin.setStatus(Constants.FAIL);
        }
        // 发布事件
        SpringContextHolder.publishEvent(new SysOperLogLoginEvent(operLogLogin));
    }
}
