package com.springcloud.study.system.bean.vo;

import lombok.Data;

/**
 * 类 描 述: 角色和部门关联 Vo
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  13:56
 */
@Data
public class SysRoleDeptVo {
    /**
     * 属性描述: 角色ID
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 13:56
     */
    private String roleId;
    /**
     * 属性描述: 部门ID
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 13:56
     */
    private String deptId;
}
