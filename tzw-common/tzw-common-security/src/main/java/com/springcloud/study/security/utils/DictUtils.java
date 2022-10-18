package com.springcloud.study.security.utils;

import cn.hutool.json.JSONArray;
import com.springcloud.study.api.system.bean.po.SysDictData;
import com.springcloud.study.core.constant.CacheConstants;
import com.springcloud.study.core.utils.StringUtils;
import com.springcloud.study.redis.utils.RedisUtils;

import java.util.Collection;
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
        RedisUtils.setCacheObject(getCacheKey(key), dictDatas);
    }

    /**
     * 获取字典缓存
     *
     * @param key 参数键
     * @return dictDatas 字典数据列表
     */
    public static List<SysDictData> getDictCache(String key) {
        JSONArray arrayCache = RedisUtils.getCacheObject(getCacheKey(key));
        if (StringUtils.isNotNull(arrayCache)) {
            return arrayCache.toList(SysDictData.class);
        }
        return null;
    }

    /**
     * 删除指定字典缓存
     *
     * @param key 字典键
     */
    public static void removeDictCache(String key) {
        RedisUtils.deleteObject(getCacheKey(key));
    }

    /**
     * 清空字典缓存
     */
    public static void clearDictCache() {
        Collection<String> keys = RedisUtils.keys(CacheConstants.SYS_DICT_KEY + "*");
        RedisUtils.deleteObject(keys);
    }

    /**
     * 设置cache key
     *
     * @param configKey 参数键
     * @return 缓存键key
     */
    public static String getCacheKey(String configKey) {
        return CacheConstants.SYS_DICT_KEY + configKey;
    }
}
