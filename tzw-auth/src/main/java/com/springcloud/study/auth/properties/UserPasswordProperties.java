package com.springcloud.study.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * 类 描 述: 用户密码配置
 * 作   者: 谭志伟
 * 时   间: 2022/9/27  15:40
 */
@Data
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "user.password")
public class UserPasswordProperties {

    /**
     * 密码最大错误次数
     */
    private Integer maxRetryCount;

    /**
     * 密码锁定时间（默认10分钟）
     */
    private Integer lockTime;

}
