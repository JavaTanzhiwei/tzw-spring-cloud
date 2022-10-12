package com.springcloud.study.log.event;

import com.springcloud.study.api.system.bean.po.SysOperLogOperation;
import org.springframework.context.ApplicationEvent;

/**
 * 类 描 述: 系统日志事件
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
public class SysOperLogOperationEvent extends ApplicationEvent {
    private static final long serialVersionUID = 8905017895058642111L;

    /**
     * 操作日志事件
     *
     * @param source
     */
    public SysOperLogOperationEvent(SysOperLogOperation source) {
        super(source);
    }
}
