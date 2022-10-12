package com.springcloud.study.log.event;

import com.springcloud.study.api.system.bean.po.SysOperLogLogin;
import org.springframework.context.ApplicationEvent;

/**
 * 类 描 述: 访问日志事件
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
public class SysOperLogLoginEvent extends ApplicationEvent {
    private static final long serialVersionUID = -9084676463718966036L;

    /**
     * 访问日志事件
     *
     * @param source
     */
    public SysOperLogLoginEvent(SysOperLogLogin source) {
        super(source);
    }
}
