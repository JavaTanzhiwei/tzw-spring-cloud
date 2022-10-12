package com.springcloud.study.gateway.config.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 类 描 述: 放行白名单配置
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  16:05
 */
@Data
@NoArgsConstructor
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "security.ignore")
public class IgnoreWhiteProperties {
    /**
     * 属性描述: 放行白名单配置，网关不校验此处的白名单
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:51
     */
    private List<String> whites = new ArrayList<>();

}

