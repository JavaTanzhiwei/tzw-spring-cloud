package com.springcloud.study.socket.command;

import lombok.Data;

import java.io.Serializable;

/**
 * 类 描 述: WEB_SOCKET消息模式
 * 作   者: 谭志伟
 * 时   间: 2022/10/11  16:40
 */
@Data
public class WebSocketMsgCommand implements Serializable {
    private static final long serialVersionUID = 4303086270200901686L;

    /**
     * 属性描述:
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:42
     */
    private String msg;
    /**
     * 属性描述:
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:42
     */
    private String command;
    /**
     * 属性描述: 命令的消息类型：默认是发送的同类型
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:42
     */
    private String type;
    /**
     * 属性描述: 发送的对象
     * 1.ALL 发送给全部
     * 2.DEP_XX 发送给某个部门
     * 3.ROLE_XX 发送给某个角色
     * 4.USER1,USER2,USER3,...,USERN  发送给某些人
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:42
     */
    private String target;
    /**
     * 属性描述: 转发内容
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:42
     */
    private String forwardMsg;

}
