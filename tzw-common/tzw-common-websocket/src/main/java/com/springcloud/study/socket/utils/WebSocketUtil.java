package com.springcloud.study.socket.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.springcloud.study.core.constant.MagicConstant;
import com.springcloud.study.core.constant.ServiceNameConstants;
import com.springcloud.study.core.interfaces.MsgUtil;
import com.springcloud.study.core.utils.RibbonUtils;
import com.springcloud.study.socket.bean.WebSocketBean;
import com.springcloud.study.socket.command.WebSocketMsgCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 类 描 述:
 * 作   者: 谭志伟
 * 时   间: 2022/10/11  17:13
 */
@Component
@Slf4j
public class WebSocketUtil implements MsgUtil {
    /**
     * 方法描述: 发给某些人，多个用逗号隔开
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 17:16
     */
    @Override
    public void sendToUser(String msg, String userId, String... other) {
        // 单个用户则需要补上逗号
        if (!userId.contains(MagicConstant.SPLIT_DEFAULT_CHAR)) {
            userId += MagicConstant.SPLIT_DEFAULT_CHAR;
        }
        doSendMsg(msg, other[0], userId);
    }

    /**
     * 方法描述: 发给所有人
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 17:20
     */
    @Override
    public void sendToAll(String msg, String... other) {
        doSendMsg(msg, other[0], MagicConstant.WEB_SOCKET_COMMAND_ALL);
    }

    /**
     * 方法描述: 实际发送消息的方法
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 17:16
     */
    private static void doSendMsg(String msg, String type, String target) {
        WebSocketBean msgBean = new WebSocketBean();
        WebSocketMsgCommand command = new WebSocketMsgCommand();
        command.setCommand("FORWARD");
        command.setType(type);
        command.setTarget(target);
        command.setForwardMsg(msg);
        msgBean.setMsg(JSONUtil.toJsonStr(command));
        String post = HttpUtil.post(RibbonUtils.getPreUrl(ServiceNameConstants.SYSTEM_TOOLS) + "/websocket/sendWebSocket/", JSONUtil.toJsonStr(msgBean));
        log.info("WEB_SOCKET消息内容:{},消息对象:{},相应信息:{}", msg, target, JSONUtil.toJsonStr(post));
    }
}
