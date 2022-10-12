package com.springcloud.study.api.system.handler;

import cn.dev33.satoken.id.SaIdUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * 类 描 述: feign拦截器, 在feign请求发出之前，加入一些操作
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  16:10
 */
@Component
public class FeignInterceptor implements RequestInterceptor {
    /**
     * 方法描述: 为 Feign 的 RCP调用 添加请求头Id-Token
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 14:12
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(SaIdUtil.ID_TOKEN, SaIdUtil.getToken());
    }
}

