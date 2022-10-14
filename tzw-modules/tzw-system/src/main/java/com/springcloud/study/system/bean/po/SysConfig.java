package com.springcloud.study.system.bean.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.springcloud.study.core.base.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 类 描 述: 参数配置表 sys_config
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  16:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_config")
public class SysConfig extends BasePo {
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
