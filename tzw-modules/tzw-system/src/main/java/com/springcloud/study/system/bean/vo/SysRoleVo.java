package com.springcloud.study.system.bean.vo;

import com.springcloud.study.core.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 类 描 述: 角色管理 Vo
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  10:24
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleVo extends BaseVo {
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
    private boolean menuCheckStrictly;
    /**
     * 属性描述: 部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 10:05
     */
    private boolean deptCheckStrictly;
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
}
