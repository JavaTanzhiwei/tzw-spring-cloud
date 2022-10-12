package com.springcloud.study.kafka.log.service;

import cn.hutool.json.JSONUtil;
import com.springcloud.study.common.kafka.bean.KafkaMsgBean;
import com.springcloud.study.kafka.base.KafkaParseBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类 描 述: 日志消息队列
 * 作   者: 谭志伟
 * 时   间: 2022/10/10  15:24
 */
@Service
@Slf4j
public class OperLogService extends KafkaParseBase {
    /**
     * 方法描述: 解析消息
     * 作   者: 谭志伟
     * 时   间: 2022/10/10 15:29
     */
    public void parseDefault(KafkaMsgBean kafkaMsgBean) {
        // 接收系统消息
        log.info("接收日志消息{}", kafkaMsgBean);
        /**
         * 发送WebSocket {link:https://gitee.com/JavaTanzhiwei/tzw-websocket-client}
         * 我的gitee可以直接模拟websocket客户端
         */
        List<String> webSocketUserIdList = new ArrayList<>();
        webSocketUserIdList.add("4f2d09177f57b064ddf280a9c79f8d92");
        sendWebSocketAlarmNotice(JSONUtil.toJsonStr(kafkaMsgBean.getRsp()), webSocketUserIdList);
    }
}
