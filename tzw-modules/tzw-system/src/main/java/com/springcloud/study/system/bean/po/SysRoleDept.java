package com.springcloud.study.system.bean.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 类 描 述: 角色和部门关联 sys_role_dept
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  13:55
 */
@Data
@TableName("sys_user_role")
public class SysRoleDept implements Serializable {
    private static final long serialVersionUID = -3272204838672363228L;
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
