package com.springcloud.study.kafka.base;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONObject;
import com.springcloud.study.common.kafka.config.KafkaConfig;
import com.springcloud.study.socket.enums.WebSocketMsgTypeEnum;
import com.springcloud.study.socket.utils.WebSocketUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * 类 描 述: Kafka解析基类
 * 作   者: 谭志伟
 * 时   间: 2022/10/10  16:08
 */

@Slf4j
public abstract class KafkaParseBase {
    /**
     * 属性描述: 注入消息队列Topic
     * 作   者: 谭志伟
     * 时   间: 2022/10/12 11:09
     */
    @Resource
    protected KafkaConfig kafkaConfig;
    @Resource
    WebSocketUtil webSocketUtil;

    /**
     * 方法描述: 发送WebSocket通知
     * 作   者: 谭志伟
     * 时   间: 2022/10/12 11:07
     */
    @Async
    public void sendWebSocketAlarmNotice(String msg, Collection<String> userIdList) {
        if (CollectionUtil.isNotEmpty(userIdList)) {
            webSocketUtil.sendToUser(msg, CollUtil.join(userIdList, ","), WebSocketMsgTypeEnum.KAFKA_NOTICE.code);
        }
    }
}
