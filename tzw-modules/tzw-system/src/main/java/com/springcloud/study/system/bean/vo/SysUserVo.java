package com.springcloud.study.system.bean.vo;

import lombok.Data;

/**
 * 类 描 述: 用户管理 Vo
 * 作   者: 谭志伟
 * 时   间: 2022/9/21  13:39
 */
@Data
public class SysUserVo {
    /**
     * 属性描述: 姓名
     * 作   者: 谭志伟
     * 时   间: 2022/9/21 10:23
     */
    private String userName;
    /**
     * 属性描述: 邮箱
     * 作   者: 谭志伟
     * 时   间: 2022/9/21 10:23
     */
    private String email;
}
