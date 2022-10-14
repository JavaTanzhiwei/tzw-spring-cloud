package com.springcloud.study.system.bean.vo;

import com.springcloud.study.core.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 类 描 述: 字典类型 Vo
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  10:24
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDictTypeVo extends BaseVo {
    /**
     * 属性描述: 字典名称
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:18
     */
    private String dictName;
    /**
     * 属性描述: 字典类型
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:18
     */
    private String dictType;
    /**
     * 属性描述: 状态（0正常 1停用）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:18
     */
    private String status;
    /**
     * 属性描述: 备注
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:18
     */
    private String remark;
}
