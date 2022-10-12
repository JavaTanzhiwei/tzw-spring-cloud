package com.springcloud.study.gateway.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * 类 描 述: 自定义gateway参数配置
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  16:14
 */
@Data
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "spring.cloud.gateway")
public class CustomGatewayProperties {
    /**
     * 属性描述: 请求日志
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:49
     */
    private Boolean requestLog;

}
