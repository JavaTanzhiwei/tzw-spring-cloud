package com.springcloud.study.kafka.log.consumer;

import cn.hutool.json.JSONUtil;
import com.springcloud.study.common.kafka.bean.KafkaMsgBean;
import com.springcloud.study.kafka.log.service.OperLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 类 描 述: 单个消费Kafka
 * 作   者: 谭志伟
 * 时   间: 2022/10/10  15:24
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class OperLogConsumer {
    private final OperLogService operLogService;

    /**
     * 方法描述: 单个消费Kafka
     * 作   者: 谭志伟
     * 时   间: 2022/10/10 15:33
     */
    @KafkaListener(topics = {"${queue.topic.tzw.operlog}"}, groupId = "${kafka.consumer.group-id.operlog}")
    public void listen(ConsumerRecord<String, String> record) {
        // 获取对象
        KafkaMsgBean kafkaAlarmBean = JSONUtil.toBean(record.value(), KafkaMsgBean.class);
        try {
            // 解析消息
            operLogService.parseDefault(kafkaAlarmBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
