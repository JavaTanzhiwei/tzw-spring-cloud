package com.springcloud.study.system.bean.vo;

import com.springcloud.study.core.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 类 描 述: 参数配置表 Vo
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  16:28
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysConfigVo extends BaseVo {
    /**
     * 属性描述: 参数名称
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:27
     */
    private String configName;
    /**
     * 属性描述: 参数键名
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:27
     */
    private String configKey;
    /**
     * 属性描述: 参数键值
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:27
     */
    private String configValue;
    /**
     * 属性描述: 备注
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:27
     */
    private String remark;
}
