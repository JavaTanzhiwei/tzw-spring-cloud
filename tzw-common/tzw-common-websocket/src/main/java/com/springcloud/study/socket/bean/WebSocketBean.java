package com.springcloud.study.socket.bean;

import com.springcloud.study.socket.command.WebSocketMsgCommand;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 类 描 述:
 * 作   者: 谭志伟
 * 时   间: 2022/10/11  16:58
 */
@Data
@NoArgsConstructor
public class WebSocketBean implements Serializable {
    private static final long serialVersionUID = -4414403717467287463L;

    /**
     * 属性描述: WEB_SOCKET {@link WebSocketMsgCommand}
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:59
     */
   private String msg;

}
