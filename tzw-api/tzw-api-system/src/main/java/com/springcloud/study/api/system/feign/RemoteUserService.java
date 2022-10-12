package com.springcloud.study.api.system.feign;

import com.springcloud.study.api.system.feign.factory.RemoteUserFallbackFactory;
import com.springcloud.study.api.system.handler.FeignInterceptor;
import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 类 描 述: 用户 Feign服务层
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@FeignClient(name = ServiceNameConstants.SYSTEM_SERVICE, configuration = FeignInterceptor.class, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService {


    /**
     * 方法描述: 根据用户名称获取用户信息
     * 作   者: 谭志伟
     * 时   间: 2022/9/28 15:51
     */
    @GetMapping("sys/user/getUserInfo")
    AjaxResult getUserInfo(@RequestParam("username") String username);

}
