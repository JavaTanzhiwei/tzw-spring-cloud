package com.springcloud.study.system.bean.vo;

import lombok.Data;

/**
 * 类 描 述: 用户和角色关联 Vo
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  13:51
 */
@Data
public class SysUserRoleVo {
    /**
     * 属性描述: 用户ID
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 13:50
     */
    private String userId;
    /**
     * 属性描述: 角色ID
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 13:50
     */
    private String roleId;
}
