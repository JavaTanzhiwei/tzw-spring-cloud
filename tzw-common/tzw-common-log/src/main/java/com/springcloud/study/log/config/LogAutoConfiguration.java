package com.springcloud.study.log.config;

import com.springcloud.study.api.system.feign.RemoteLogService;
import com.springcloud.study.log.aspect.OperLogAspect;
import com.springcloud.study.log.listener.LogListener;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 类 描 述: 操作日志记录自动配置
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@EnableAsync
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class LogAutoConfiguration {

    private final RemoteLogService logService;

    @Bean
    public LogListener sysOperLogListener() {
        return new LogListener(logService);
    }

    @Bean
    public OperLogAspect operLogAspect() {
        return new OperLogAspect();
    }
}
