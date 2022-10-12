package com.springcloud.study.gateway.filter;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.springcloud.study.core.constant.HttpStatus;
import com.springcloud.study.gateway.config.properties.IgnoreWhiteProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类 描 述: [Sa-Token 权限认证] 拦截器
 * 作   者: 谭志伟
 * 时   间: 2022/9/26  15:34
 */
@Configuration
public class AuthFilter {
    /**
     * 方法描述: 注册 [Sa-Token全局过滤器]
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:51
     */
    @Bean
    public SaReactorFilter getSaServletFilter(IgnoreWhiteProperties ignoreWhite) {
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")
                .setExcludeList(ignoreWhite.getWhites())
                .addExclude("/favicon.ico", "/actuator/**")
                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    // 登录校验 -- 拦截所有路由
                    SaRouter.match("/**")
                            .check(r -> {
                                // 检查是否登录 是否有token
                                StpUtil.checkLogin();
                            });
                }).setError(e -> SaResult.error("认证失败，无法访问系统资源").setCode(HttpStatus.UNAUTHORIZED));
    }
}
