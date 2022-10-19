package com.springcloud.study.core.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 类 描 述: stream 流工具类
 * 作   者: 谭志伟
 * 时   间: 2022/9/21  14:06
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StreamUtils {

    /**
     * 方法描述: 将collection转化为List集合a
     * 作   者: 谭志伟
     * 时   间: 2022/9/21 14:07
     */
    public static <E, T> List<T> toList(Collection<E> collection, Function<E, T> function) {
        if (CollUtil.isEmpty(collection)) {
            return CollUtil.newArrayList();
        }
        return collection
                .stream()
                .map(function)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * 方法描述: 将collection拼接
     * 作   者: 谭志伟
     * 时   间: 2022/10/05 21:27
     */
    public static <E> String join(Collection<E> collection, Function<E, String> function) {
        return join(collection, function, ",");
    }

    /**
     * 方法描述: 将collection拼接
     * 作   者: 谭志伟
     * 时   间: 2022/10/05 21:27
     */
    public static <E> String join(Collection<E> collection, Function<E, String> function, CharSequence delimiter) {
        if (CollUtil.isEmpty(collection)) {
            return StrUtil.EMPTY;
        }
        return collection.stream().map(function).filter(Objects::nonNull).collect(Collectors.joining(delimiter));
    }

    /**
     * 将collection按照规则(比如有相同的班级id)分类成map<br>
     * <B>{@code Collection<E> -------> Map<K,List<E>> } </B>
     *
     * @param collection 需要分类的集合
     * @param key        分类的规则
     * @param <E>        collection中的泛型
     * @param <K>        map中的key类型
     * @return 分类后的map
     */
    public static <E, K> Map<K, List<E>> groupByKey(Collection<E> collection, Function<E, K> key) {
        if (CollUtil.isEmpty(collection)) {
            return MapUtil.newHashMap();
        }
        return collection
                .stream()
                .collect(Collectors.groupingBy(key, LinkedHashMap::new, Collectors.toList()));
    }

    /**
     * 将collection排序
     *
     * @param collection 需要转化的集合
     * @param comparing  排序方法
     * @return 排序后的list
     */
    public static <E> List<E> sorted(Collection<E> collection, Comparator<E> comparing) {
        if (CollUtil.isEmpty(collection)) {
            return CollUtil.newArrayList();
        }
        return collection.stream().sorted(comparing).collect(Collectors.toList());
    }
}
