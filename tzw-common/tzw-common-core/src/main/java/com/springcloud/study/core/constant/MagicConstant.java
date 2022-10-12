package com.springcloud.study.core.constant;

import org.apache.commons.lang3.ObjectUtils;

/**
 * 类 描 述: 魔法值常量  ObjectUtils.CONST()
 * 作   者: 谭志伟
 * 时   间: 2022/10/11  16:50
 */
public interface MagicConstant {
    /**
     * WEB_SOCKET命令标识
     */
    String WEB_SOCKET_COMMAND_ALL = ObjectUtils.CONST("ALL");
    String WEB_SOCKET_COMMAND_DEP = ObjectUtils.CONST("DEP_");
    String WEB_SOCKET_COMMAND_ROLE = ObjectUtils.CONST("ROLE_");
    /**
     * 默认字符串分隔符
     */
    String SPLIT_DEFAULT_CHAR = ObjectUtils.CONST(",");
    String SPLIT_POINT = ObjectUtils.CONST("\\.");
    String SPLIT_UNDERSCORE_CHAR = ObjectUtils.CONST("_");
}
