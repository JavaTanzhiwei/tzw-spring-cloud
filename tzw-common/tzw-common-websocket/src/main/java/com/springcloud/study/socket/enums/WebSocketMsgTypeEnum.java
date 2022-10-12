package com.springcloud.study.socket.enums;

/**
 * 类 描 述: WebSocket 消息类型
 * 作   者: 谭志伟
 * 时   间: 2022/10/11  16:45
 */
public enum WebSocketMsgTypeEnum {
    /**
     * 属性描述: 枚举实例
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:46
     */
    LOGOFF_NOTICE("LOGOFF_NOTICE", "下线通知"),
    KAFKA_NOTICE("KAFKA_NOTICE","KAFKA通知"),
    FORWARD_COMMAND("FORWARD_COMMAND", "转发命令");
    public final String code;
    public final String name;

    WebSocketMsgTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
