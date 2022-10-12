package com.springcloud.study.core.utils;

import cn.hutool.bloomfilter.BitMapBloomFilter;

import java.util.HashMap;
import java.util.Map;

/**
 * 类 描 述: 布隆过滤器工具类
 * 作   者: 谭志伟
 * 时   间: 2022/10/10  15:07
 */
public class BloomFilterUtils {
    public static Map<String, Map<String, BitMapBloomFilter>> map = new HashMap<>(16);

    /**
     * 方法描述: 判断KEY值是否存在
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 11:31
     */
    public static Boolean contains(String serviceName, String type, String id) {
        BitMapBloomFilter filter = getFilter(serviceName, type);
        boolean contains = filter.contains(id);
        // 不存在则新增
        if (!contains) {
            filter.add(id);
        }
        return contains;
    }

    /**
     * 方法描述: 判断是否存在但不添加
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 11:31
     */
    public static Boolean containsNoAdd(String serviceName, String type, String id) {
        BitMapBloomFilter filter = getFilter(serviceName, type);
        return filter.contains(id);
    }

    /**
     * 方法描述: 获取过滤器
     * 作   者: 谭志伟
     * 时   间: 2022/10/11 11:31
     */
    private static BitMapBloomFilter getFilter(String serviceName, String type) {
        if (map.containsKey(serviceName)) {
            Map<String, BitMapBloomFilter> typeMap = map.get(serviceName);
            if (typeMap.containsKey(type)) {
                return typeMap.get(type);
            } else {
                // 创建过滤器
                BitMapBloomFilter filter = new BitMapBloomFilter(10);
                typeMap.put(type, filter);
                return filter;
            }
        } else {
            // 创建过滤器
            BitMapBloomFilter filter = new BitMapBloomFilter(10);
            // 将过滤器塞入MAP中
            Map<String, BitMapBloomFilter> typeMap = new HashMap<>(16);
            typeMap.put(type, filter);
            map.put(serviceName, typeMap);
            // 返回过滤器
            return filter;
        }
    }
}
