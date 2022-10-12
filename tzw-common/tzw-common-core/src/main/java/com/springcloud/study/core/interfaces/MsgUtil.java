package com.springcloud.study.core.interfaces;

/**
 * 类 描 述: 消息发送,暂时只实现了WEB_SOCKET
 * 作   者: 谭志伟
 * 时   间: 2022/10/11  17:15
 */
public interface MsgUtil {

    /**
     * 方法描述: 发给某些人，多个用逗号隔开
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 17:15
     */
    void sendToUser(String msg, String userId, String... other);

    /**
     * 方法描述: 发给所有人
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 17:20
     */
    void sendToAll(String msg, String... other);

}
