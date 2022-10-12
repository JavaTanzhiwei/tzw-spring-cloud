package com.springcloud.study.api.system.feign.factory;

import com.springcloud.study.api.system.feign.RemoteUserService;
import com.springcloud.study.core.api.AjaxResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 类 描 述: 用户 Feign服务层降级处理，统一拦截异常
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@Slf4j
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {


    @Override
    public RemoteUserService create(Throwable throwable) {
        return new RemoteUserService() {
            /**
             * 根据用户名称查询用户信息
             * @param username
             * @return
             */
            @Override
            public AjaxResult getUserInfo(String username) {
                return AjaxResult.error("无法访问");
            }
        };
    }
}
