package com.springcloud.study.common.kafka.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 类 描 述: Kafka消息队列
 * 作   者: 谭志伟
 * 时   间: 2022/10/10  15:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KafkaMsgBean implements Serializable {
    private static final long serialVersionUID = -2634120714045856526L;
    /**
     * 属性描述: 日志ID
     * 作   者: 谭志伟
     * 时   间: 2022/10/10 15:01
     */
    private String id;
    /**
     * 属性描述: 日志类型
     * 作   者: 谭志伟
     * 时   间: 2022/10/10 15:01
     */
    private String type;
    /**
     * 属性描述: 接口报文
     * 作   者: 谭志伟
     * 时   间: 2022/10/10 15:01
     */
    private String rsp;
    /**
     * 属性描述: 模块名称
     * 作   者: 谭志伟
     * 时   间: 2022/10/10 15:01
     */
    private String serviceName;
}
