package com.springcloud.study.api.system.feign.factory;

import com.springcloud.study.api.system.bean.po.SysOperLogLogin;
import com.springcloud.study.api.system.bean.po.SysOperLogOperation;
import com.springcloud.study.api.system.feign.RemoteLogService;
import com.springcloud.study.core.api.AjaxResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 类 描 述: 日志 Feign服务层降级处理，统一拦截异常
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@Slf4j
@Component
public class RemoteLogFallbackFactory implements FallbackFactory<RemoteLogService> {
    @Override
    public RemoteLogService create(Throwable throwable) {
        return new RemoteLogService() {
            @Override
            public AjaxResult saveLogOperation(SysOperLogOperation operLogDto) {
                return AjaxResult.error("无法访问");
            }

            @Override
            public AjaxResult saveLogLogin(SysOperLogLogin operLogLogin) {
                return AjaxResult.error("无法访问");
            }
        };
    }
}
