package com.springcloud.study.core.utils;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;

/**
 * 类 描 述: Ribbon的各种工具
 * 作   者: 谭志伟
 * 时   间: 2022/10/11  17:17
 */
public class RibbonUtils {
    static RibbonLoadBalancerClient balancerClient;

    /**
     * 方法描述: 获取URL前缀
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 17:18
     */
    public static String getPreUrl(String serviceId) {
        if (balancerClient == null) {
            balancerClient = SpringUtil.getBean(RibbonLoadBalancerClient.class);
        }
        ServiceInstance instance = balancerClient.choose(serviceId);
        return "http://" + instance.getHost() + ":" + instance.getPort();
    }
}
