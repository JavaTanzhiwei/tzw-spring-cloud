package com.springcloud.study.tools.websocket.controller;

import cn.hutool.json.JSONUtil;
import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.socket.bean.WebSocketBean;
import com.springcloud.study.socket.command.WebSocketMsgCommand;
import com.springcloud.study.tools.websocket.service.WebsocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类 描 述:
 * 作   者: 谭志伟
 * 时   间: 2022/10/11  17:02
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/websocket")
public class WebSocketController {
    private final WebsocketService websocketService;

    /**
     * 方法描述: 发送WEB_SOCKET
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 17:03
     */
    @RequestMapping("/sendWebSocket")
    public AjaxResult sendWebSocket(@RequestBody WebSocketBean webSocketBean) {
        return websocketService.sendWebSocket(webSocketBean);
    }

    @RequestMapping("/sendWebSocketTest")
    public AjaxResult sendWebSocketTest(@RequestBody WebSocketMsgCommand command) {
        WebSocketBean webSocketBean = new WebSocketBean();
        webSocketBean.setMsg(JSONUtil.toJsonStr(command));
        return websocketService.sendWebSocket(webSocketBean);
    }
}
