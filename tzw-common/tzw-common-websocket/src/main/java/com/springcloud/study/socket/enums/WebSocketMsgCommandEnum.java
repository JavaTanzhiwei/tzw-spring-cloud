package com.springcloud.study.socket.enums;

/**
 * 类 描 述: WebSocket 消息命令
 * 作   者: 谭志伟
 * 时   间: 2022/10/11  16:47
 */
public enum WebSocketMsgCommandEnum {
    /**
     * 属性描述: 枚举实例
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:47
     */
    NOTICE("NOTICE", "通知"),
    FORWARD("FORWARD", "转发");

    public String code;
    public String name;

    WebSocketMsgCommandEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
