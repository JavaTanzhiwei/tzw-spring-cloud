package com.springcloud.study.log.enums;

/**
 * 类 描 述: 业务操作类型
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
public enum BusinessType {
    /**
     * 其它
     */
    OTHER,
    /**
     * 查询
     */
    SELECT,
    /**
     * 新增
     */
    INSERT,

    /**
     * 修改
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 授权
     */
    GRANT,

    /**
     * 导出
     */
    EXPORT,

    /**
     * 导入
     */
    IMPORT,

    /**
     * 强退
     */
    FORCE,

    /**
     * 生成代码
     */
    GENCODE,

    /**
     * 清空数据
     */
    CLEAN,
}
