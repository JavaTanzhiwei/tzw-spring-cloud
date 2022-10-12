package com.springcloud.study.api.system.bean.po;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springcloud.study.core.base.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 类 描 述: 用户对象 sys_user
 * 作   者: 谭志伟
 * 时   间: 2022/9/27  15:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
public class SysUser extends BasePo {
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

    /**
     * 属性描述: 手机号码
     * 作   者: 谭志伟
     * 时   间: 2022/9/27 16:01
     */
    private String phonenumber;
    /**
     * 属性描述: 手机号码
     * 作   者: 谭志伟
     * 时   间: 2022/9/27 16:01
     */
    private String sex;
    /**
     * 属性描述: 用户头像
     * 作   者: 谭志伟
     * 时   间: 2022/9/27 16:01
     */
    private String avatar;
    /**
     * 属性描述: 密码
     * 作   者: 谭志伟
     * 时   间: 2022/9/27 16:01
     */
    @TableField(
            insertStrategy = FieldStrategy.NOT_EMPTY,
            updateStrategy = FieldStrategy.NOT_EMPTY,
            whereStrategy = FieldStrategy.NOT_EMPTY
    )
    private String password;
    /**
     * 属性描述: 删除标志（0代表存在 2代表删除）
     * 作   者: 谭志伟
     * 时   间: 2022/9/27 16:01
     */
    private String status;

    /**
     * 属性描述: 用户类型（sys_user系统用户）
     * 作   者: 谭志伟
     * 时   间: 2022/9/27 19:31
     */
    private String userType;

    /**
     * 属性描述: 手机号码
     * 作   者: 谭志伟
     * 时   间: 2022/9/27 16:01
     */
    @TableLogic
    private String delFlag;
    /**
     * 属性描述: 最后登录IP
     * 作   者: 谭志伟
     * 时   间: 2022/9/27 16:01
     */
    private String loginIp;
    /**
     * 属性描述: 最后登录时间
     * 作   者: 谭志伟
     * 时   间: 2022/9/27 16:01
     */
    private Date loginDate;
    /**
     * 属性描述: 备注
     * 作   者: 谭志伟
     * 时   间: 2022/9/27 16:01
     */
    private String remark;
}
