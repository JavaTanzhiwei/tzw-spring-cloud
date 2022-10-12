package com.springcloud.study.gateway.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 类 描 述: XSS跨站脚本配置
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  16:05
 */
@Data
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "security.xss")
public class XssProperties {
    /**
     * 属性描述: Xss开关
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:49
     */
    private Boolean enabled;
    /**
     * 属性描述: 排除路径
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:51
     */
    private List<String> excludeUrls = new ArrayList<>();

}
