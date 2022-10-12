package com.springcloud.study.common.kafka.utils;

import cn.hutool.extra.spring.SpringUtil;
import com.springcloud.study.common.kafka.bean.KafkaLogBean;
import com.springcloud.study.common.kafka.bean.KafkaMsgBean;
import com.springcloud.study.core.utils.BloomFilterUtils;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * 类 描 述: Kafka工具类
 * 作   者: 谭志伟
 * 时   间: 2022/10/10  15:05
 */
public class KafkaUtils {
    private static KafkaTemplate<Object, Object> kafkaTemplate;

    /**
     * 向kafka发送日志数据
     *
     * @param type        类型
     * @param url         请求地址
     * @param rsp         返回结构
     * @param serviceName 模块名称
     */
    public static void sendKafkaLogMsg(String type, String url, String rsp, String serviceName) {
        KafkaLogBean data = new KafkaLogBean(type, url, rsp, serviceName);
        doSend(type, data);
    }

    /**
     * 向Kafka发送数据
     *
     * @param id          数据ID
     * @param type        类型
     * @param msg         返回结构（json）
     * @param serviceName 模块名称
     */
    public static void sendKafkaServiceMsg(String id, String type, String msg, String serviceName) {
        // 先判断是否为重复数据
        Boolean contains = BloomFilterUtils.contains(serviceName, type, id);
        if (!contains) {
            KafkaMsgBean data = new KafkaMsgBean(id, type, msg, serviceName);
            doSend(type, data);
        }
    }


    /**
     * 发送kafka消息队列
     *
     * @param topic Kafka消息队列分组Topic
     * @param data  返回结构（json）
     */
    private static void doSend(String topic, Object data) {
        if (kafkaTemplate == null) {
            kafkaTemplate = SpringUtil.getBean(KafkaTemplate.class);
        }
        kafkaTemplate.send(topic, data);
    }
}
