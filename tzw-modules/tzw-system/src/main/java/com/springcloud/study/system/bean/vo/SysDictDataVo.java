package com.springcloud.study.system.bean.vo;

import com.springcloud.study.core.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 类 描 述: 字典数据 Vo
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  10:24
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDictDataVo extends BaseVo {
    /**
     * 属性描述: 字典排序
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:20
     */
    private Integer dictSort;
    /**
     * 属性描述: 字典标签
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:20
     */
    private String dictLabel;
    /**
     * 属性描述: 字典键值
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:20
     */
    private String dictValue;
    /**
     * 属性描述: 字典类型
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:20
     */
    private String dictType;
    /**
     * 属性描述: 是否默认（Y是 N否）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:20
     */
    private String isDefault;
    /**
     * 属性描述: 状态（0正常 1停用）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:20
     */
    private String status;
    /**
     * 属性描述: 备注
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:20
     */
    private String remark;
}
