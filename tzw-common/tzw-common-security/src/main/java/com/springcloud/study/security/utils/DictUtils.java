package com.springcloud.study.security.utils;

import com.springcloud.study.api.system.bean.po.SysDictData;
import com.springcloud.study.core.constant.CacheConstants;
import com.springcloud.study.redis.utils.CacheUtils;

import java.util.List;

/**
 * 类 描 述: 字典工具类
 * 作   者: 谭志伟
 * 时   间: 2022/10/18  11:35
 */
public class DictUtils {

    /**
     * 设置字典缓存
     *
     * @param key       参数键
     * @param dictDatas 字典数据列表
     */
    public static void setDictCache(String key, List<SysDictData> dictDatas) {
        CacheUtils.put(CacheConstants.SYS_DICT, key, dictDatas);
    }

    /**
     * 获取字典缓存
     *
     * @param key 参数键
     * @return dictDatas 字典数据列表
     */
    public static List<SysDictData> getDictCache(String key) {
        return CacheUtils.get(CacheConstants.SYS_DICT, key);
    }

    /**
     * 删除指定字典缓存
     *
     * @param key 字典键
     */
    public static void removeDictCache(String key) {
        CacheUtils.evict(CacheConstants.SYS_DICT, key);
    }

    /**
     * 清空字典缓存
     */
    public static void clearDictCache() {
        CacheUtils.clear(CacheConstants.SYS_DICT);
    }
}
