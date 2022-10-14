package com.springcloud.study.system.bean.vo;

import com.springcloud.study.core.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 类 描 述: 部门管理 Vo
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  10:24
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDeptVo extends BaseVo {
    /**
     * 属性描述: 父部门ID
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:16
     */
    private String parentId;
    /**
     * 属性描述: 祖级列表
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:16
     */
    private String ancestors;
    /**
     * 属性描述: 部门名称
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:16
     */
    private String deptName;
    /**
     * 属性描述: 显示顺序
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:16
     */
    private Integer orderNum;
    /**
     * 属性描述: 负责人
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:16
     */
    private String leader;
    /**
     * 属性描述: 联系电话
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:16
     */
    private String phone;
    /**
     * 属性描述: 邮箱
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:16
     */
    private String email;
    /**
     * 属性描述: 部门状态:0正常,1停用
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:16
     */
    private String status;
    /**
     * 属性描述: 删除标志（0代表存在 2代表删除）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:16
     */
    private String delFlag;
}
