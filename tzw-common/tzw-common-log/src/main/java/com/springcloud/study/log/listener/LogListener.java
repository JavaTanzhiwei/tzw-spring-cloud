package com.springcloud.study.log.listener;

import com.springcloud.study.api.system.bean.po.SysOperLogLogin;
import com.springcloud.study.api.system.bean.po.SysOperLogOperation;
import com.springcloud.study.api.system.feign.RemoteLogService;
import com.springcloud.study.log.event.SysOperLogLoginEvent;
import com.springcloud.study.log.event.SysOperLogOperationEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * 类 描 述: 系统日志事件监听
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@Slf4j
@AllArgsConstructor
public class LogListener {
    private final RemoteLogService remoteLogService;

    /**
     * 系统操作日志
     *
     * @param event
     */
    @Async
    @Order
    @EventListener(SysOperLogOperationEvent.class)
    public void listenOperLogOperation(SysOperLogOperationEvent event) {
        SysOperLogOperation sysOperLogOperation = (SysOperLogOperation) event.getSource();
        remoteLogService.saveLogOperation(sysOperLogOperation);
        log.info("远程操作日志记录成功：{}", sysOperLogOperation);
    }

    /**
     * 系统访问日志
     *
     * @param event
     */
    @Async
    @Order
    @EventListener(SysOperLogLoginEvent.class)
    public void listenOperLogLogin(SysOperLogLoginEvent event) {
        SysOperLogLogin sysOperLogLogin = (SysOperLogLogin) event.getSource();
        remoteLogService.saveLogLogin(sysOperLogLogin);
        log.info("远程访问日志记录成功：{}", sysOperLogLogin);
    }
}
