package com.springcloud.study.api.system.feign;

import com.springcloud.study.api.system.bean.po.SysOperLogLogin;
import com.springcloud.study.api.system.bean.po.SysOperLogOperation;
import com.springcloud.study.api.system.feign.factory.RemoteLogFallbackFactory;
import com.springcloud.study.api.system.handler.FeignInterceptor;
import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 类 描 述: 日志 Feign服务层
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@FeignClient(name = ServiceNameConstants.SYSTEM_SERVICE, configuration = FeignInterceptor.class, fallbackFactory = RemoteLogFallbackFactory.class)
public interface RemoteLogService {

    /**
     * 方法描述: 保存系统日志
     * 作   者: 谭志伟
     * 时   间: 2022/9/28 15:51
     */
    @PostMapping("log/operation")
    AjaxResult saveLogOperation(@RequestBody SysOperLogOperation operLogOperation);

    /**
     * 方法描述: 保存访问日志
     * 作   者: 谭志伟
     * 时   间: 2022/9/28 15:51
     */
    @PostMapping("log/login")
    AjaxResult saveLogLogin(@RequestBody SysOperLogLogin operLogLogin);
}
