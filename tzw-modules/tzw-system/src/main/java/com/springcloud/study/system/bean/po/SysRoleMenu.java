package com.springcloud.study.system.bean.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 类 描 述: 角色和菜单关联 sys_role_menu
 * 作   者: 谭志伟
 * 时   间: 2022/10/25  13:45
 */
@Data
@NoArgsConstructor
@TableName("sys_role_menu")
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = 6428050784188506754L;

    /**
     * 属性描述: 角色ID
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 13:46
     */
    private String roleId;
    /**
     * 属性描述: 菜单ID
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 13:46
     */
    private String menuId;
}
