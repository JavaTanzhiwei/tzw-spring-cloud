package com.springcloud.study.security.config;

import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.id.SaIdUtil;
import cn.dev33.satoken.util.SaResult;
import com.springcloud.study.core.constant.HttpStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 类 描 述: Sa-Token 权限认证 配置类
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  16:10
 */
@Configuration
public class SecurityConfiguration implements WebMvcConfigurer {
    /**
     * 方法描述: 注册 Sa-Token 全局过滤器
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 16:30
     */
    @Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter()
                .addInclude("/**")
                // 放行websocket
                .addExclude("/actuator/**", "/websocket/**")
                .setAuth(obj -> SaIdUtil.checkCurrentRequestToken())
                .setError(e -> SaResult.error(e.getMessage()).setCode(HttpStatus.UNAUTHORIZED));
    }
}
