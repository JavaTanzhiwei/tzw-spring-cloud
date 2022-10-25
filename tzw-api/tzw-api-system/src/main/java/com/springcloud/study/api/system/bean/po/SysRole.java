package com.springcloud.study.api.system.bean.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcloud.study.core.base.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * 类 描 述: 角色表 sys_role
 * 作   者: 谭志伟
 * 时   间: 2022/10/13  17:22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
public class SysRole extends BasePo {
    /**
     * 属性描述: 角色名称
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:05
     */
    private String roleName;
    /**
     * 属性描述: 角色权限
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:05
     */
    private String roleKey;
    /**
     * 属性描述: 角色排序
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:05
     */
    private Integer roleSort;
    /**
     * 属性描述: 数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:05
     */
    private String dataScope;
    /**
     * 属性描述: 菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:05
     */
    private Boolean menuCheckStrictly;
    /**
     * 属性描述: 部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:05
     */
    private Boolean deptCheckStrictly;
    /**
     * 属性描述: 角色状态（0正常 1停用）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:05
     */
    private String status;
    /**
     * 属性描述: 删除标志（0代表存在 2代表删除）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:05
     */
    private String delFlag;
    /**
     * 属性描述: 备注
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:05
     */
    private String remark;
    /**
     * 属性描述: 用户是否存在此角色标识 默认不存在
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:05
     */
    @TableField(exist = false)
    private boolean flag = false;
    /**
     * 属性描述: 菜单组
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:05
     */
    @TableField(exist = false)
    private String[] menuIds;
    /**
     * 属性描述: 部门组（数据权限）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:05
     */
    @TableField(exist = false)
    private String[] deptIds;
    /**
     * 属性描述: 角色菜单权限
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:05
     */
    @TableField(exist = false)
    private Set<String> permissions;
}
