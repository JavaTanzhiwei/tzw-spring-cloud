package com.springcloud.study.system.bean.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 类 描 述: 用户和角色关联 sys_user_role
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  13:47
 */
@Data
@TableName("sys_user_role")
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = -2429639034070090796L;
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
