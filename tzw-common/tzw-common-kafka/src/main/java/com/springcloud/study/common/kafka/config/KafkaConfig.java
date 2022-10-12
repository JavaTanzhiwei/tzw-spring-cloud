package com.springcloud.study.common.kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 类 描 述: Kafka配置参数
 * 作   者: 谭志伟
 * 时   间: 2022/10/10  15:40
 */
@Component
public class KafkaConfig {
    /**
     * 属性描述: 系统管理
     * 作   者: 谭志伟
     * 时   间: 2022/10/10 15:42
     */
    @Value("${queue.topic.tzw.system}")
    public String KAFKA_TZW_TYPE_SYSTEM;
    /**
     * 属性描述: 日志
     * 作   者: 谭志伟
     * 时   间: 2022/10/10 15:42
     */
    @Value("${queue.topic.tzw.operlog}")
    public String KAFKA_TZW_TYPE_OPERLOG;
}
