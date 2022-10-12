package com.springcloud.study.core.constant;

/**
 * 类 描 述: 缓存常量信息
 * 作   者: 谭志伟
 * 时   间: 2022/9/27  14:32
 */
public interface CacheConstants {
    /**
     * Sa-Token的token名称
     */
    String SA_TOKEN_NAME = "SaTokenName";

    /**
     * Sa-Token的token值
     */
    String SA_TOKEN_VALUE = "SaTokenValue";

    /**
     * loginid构造拼接字符串
     */
    String LOGINID_JOIN_CODE = ":";

    /**
     * 验证码 redis key
     */
    String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 参数管理 cache key
     */
    String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    String SYS_DICT_KEY = "sys_dict:";

    /**
     * 登录账户密码错误次数 redis key
     */
    String PWD_ERR_CNT_KEY = "pwd_err_cnt:";
}
