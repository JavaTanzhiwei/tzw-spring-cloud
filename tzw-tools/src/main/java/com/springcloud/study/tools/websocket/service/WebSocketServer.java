package com.springcloud.study.tools.websocket.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.springcloud.study.core.constant.MagicConstant;
import com.springcloud.study.socket.command.WebSocketMsgCommand;
import com.springcloud.study.socket.enums.WebSocketMsgCommandEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类 描 述: websocket 消息处理
 * 作   者: 谭志伟
 * 时   间: 2022/10/11  16:23
 */
@Component
@ServerEndpoint("/websocket/{type}/{token}")
@Slf4j
public class WebSocketServer {
    /**
     * 属性描述: 记录当前在线连接数
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:33
     */
    private static final Map<String, AtomicInteger> ONLINE_COUNT_MAP = new HashMap<>();
    /**
     * 属性描述: 存放所有在线的客户端,客户端就是会话:PC端或APP
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:33
     */
    public static final Map<String, Map<String, Session>> CLIENTS_MAP = new ConcurrentHashMap<>();

    /**
     * 属性描述: token
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:31
     */
    private String token;
    /**
     * 属性描述: 消息类型
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:31
     */
    private String type;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("type") String type, @PathParam("token") String token) throws Exception {
        // 在线人数加一
        inchOnlineCount(type);
        // 存放客户端
        storageClient(type, token, session);
        // 设置消息类型
        this.type = type;
        // 设置token
        this.token = token;
        // 打印日志
        log.info("消息类型为：{},有新连接加入：{}，当前在线人数为：{}", type, token, ONLINE_COUNT_MAP.get(type).get());
    }

    /**
     * 连接关闭时处理
     */
    @OnClose
    public void onClose() {
        // 在线数减1
        decrementOnlineCount();
        // 关闭连接
        removeClient();
        // 打印日志
        log.info("消息类型为：{},有一连接关闭：{}，当前在线人数为：{}", type, token, ONLINE_COUNT_MAP.get(type) == null ? 0 : ONLINE_COUNT_MAP.get(type).get());
    }

    /**
     * 抛出异常时处理
     */
    @OnError
    public void onError(@PathParam("type") String type, @PathParam("token") String token, Throwable throwable) {
        // 清除SESSION
        removeClient();
        log.error("WEB_SOCKET发送错误，类型:{},TOKEN:{},error:{}", type, token, throwable.toString());
    }

    /**
     * 服务器接收到客户端消息时调用的方法
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("服务端收到客户端[{}]的消息[{}]", token, message);
        // 获取消息对象
        WebSocketMsgCommand msgCommand = JSONUtil.parseObj(message).toBean(WebSocketMsgCommand.class);
        // 获取命令对象
        String command = msgCommand.getCommand();
        // 需要转发命令的
        if (StringUtils.isNotBlank(command) && WebSocketMsgCommandEnum.FORWARD.code.equals(command)) {
            // 获取消息类型
            String msgType = StringUtils.isNotBlank(msgCommand.getType()) ? msgCommand.getType() : type;
            // 获取消息人
            if (ONLINE_COUNT_MAP.containsKey(msgType) && ONLINE_COUNT_MAP.get(msgType).get() > 0) {
                String target = msgCommand.getTarget();
                // 发送给在线的所有人：前提是在线
                if (MagicConstant.WEB_SOCKET_COMMAND_ALL.equals(target)) {
                    sendToAll(msgType, msgCommand.getForwardMsg());
                }
                // 发送给某个部门 DEP_XX：前提是在线
                if (target.startsWith(MagicConstant.WEB_SOCKET_COMMAND_DEP)) {
                }
                // 发送给某个角色：前提是在线
                if (target.startsWith(MagicConstant.WEB_SOCKET_COMMAND_ROLE)) {
                }
                // 发送给某些用户
                if (target.contains(MagicConstant.SPLIT_DEFAULT_CHAR)) {
                    List<String> userIds = Arrays.asList(target.split(MagicConstant.SPLIT_DEFAULT_CHAR));
                    sendToUsers(msgType, msgCommand.getForwardMsg(), userIds);
                }
            }
        }
    }

    /**
     * 方法描述: 在线人数加一
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:34
     */
    private void inchOnlineCount(String type) {
        if (ONLINE_COUNT_MAP.containsKey(type)) {
            AtomicInteger onlineCount = ONLINE_COUNT_MAP.get(type);
            onlineCount.incrementAndGet();
        } else {
            AtomicInteger onlineCount = new AtomicInteger(1);
            ONLINE_COUNT_MAP.put(type, onlineCount);
        }
    }

    /**
     * 方法描述: 在线数减一
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:34
     */
    private void decrementOnlineCount() {
        if (ONLINE_COUNT_MAP.containsKey(type)) {
            AtomicInteger onlineCount = ONLINE_COUNT_MAP.get(type);
            int count = onlineCount.decrementAndGet();
            if (count <= 0) {
                ONLINE_COUNT_MAP.remove(type);
            }
        }
    }

    /**
     * 方法描述: 存放客户端
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:34
     */
    private void storageClient(String type, String token, Session session) {
        if (CLIENTS_MAP.containsKey(type)) {
            Map<String, Session> clients = CLIENTS_MAP.get(type);
            clients.put(token, session);
        } else {
            Map<String, Session> clients = new ConcurrentHashMap<>(2);
            clients.put(token, session);
            CLIENTS_MAP.put(type, clients);
        }

    }

    /**
     * 方法描述: 移除客户端
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:35
     */
    private void removeClient() {
        if (CLIENTS_MAP.containsKey(type)) {
            Map<String, Session> clients = CLIENTS_MAP.get(type);
            clients.remove(token);
            if (CollectionUtils.isEmpty(clients)) {
                CLIENTS_MAP.remove(type);
            }
        }
    }

    /**
     * 方法描述: 发送给在线的所有人
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:39
     */
    private void sendToAll(String msgType, String msg) {
        Map<String, Session> clients = CLIENTS_MAP.get(msgType);
        clients.forEach((key, value) -> {
            // 获取发送消息的人
            sendNoticeMsg(msg, value);
        });
    }

    /**
     * 方法描述: 给某些人发送通知
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:54
     */
    private void sendToUsers(String msgType, String msg, List<String> userIds) {
        // 获取所有的在线客户端
        Map<String, Session> clients = CLIENTS_MAP.get(msgType);
        if (CollectionUtil.isNotEmpty(userIds) && CollectionUtil.isNotEmpty(clients)) {
            userIds.forEach(userId -> {
                // 遍历发送消息
                clients.forEach((key, value) -> {
                    // 获取发送消息的人
                    sendNoticeMsg(msg, value);
                });
            });
        }
    }

    /**
     * 方法描述: 发送通知
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 16:40
     */
    private void sendNoticeMsg(String msg, Session session) {
        WebSocketMsgCommand msgObj = new WebSocketMsgCommand();
        msgObj.setMsg(msg);
        msgObj.setCommand(WebSocketMsgCommandEnum.NOTICE.code);
        try {
            session.getBasicRemote().sendText(JSONUtil.toJsonStr(msgObj));
            log.info("转发消息成功,msg:{}", msg);
        } catch (IOException e) {
            log.error("转发消息失败：{},forwardObj:{}", e.getMessage(), JSONUtil.toJsonStr(msgObj));
        }
    }
}
