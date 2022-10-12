package com.springcloud.study.tools.websocket.service;

import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.socket.bean.WebSocketBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 类 描 述: 消息发送
 * 作   者: 谭志伟
 * 时   间: 2022/10/11  16:56
 */
@Service
@Slf4j
public class WebsocketService {
    @Resource
    WebSocketServer webSocketServer;

    /**
     * 方法描述: 发送WebSocket消息
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:57
     */
    public AjaxResult sendWebSocket(WebSocketBean webSocketBean) {
        // 发送WebSocket消息
        webSocketServer.onMessage(webSocketBean.getMsg());
        return AjaxResult.success();
    }
}
