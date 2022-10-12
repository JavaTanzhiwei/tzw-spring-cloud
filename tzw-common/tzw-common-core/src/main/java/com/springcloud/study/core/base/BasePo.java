package com.springcloud.study.core.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 类 描 述:
 * 作   者: 谭志伟
 * 时   间: 2022/9/22  16:31
 */
@Data
public class BasePo implements Serializable {
    private static final long serialVersionUID = -1788702889679302635L;
    /**
     * 属性描述: 主键
     * 作   者: 谭志伟
     * 时   间: 2022/9/21 10:23
     */
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    /**
     * 属性描述: 创建者
     * 作   者: 谭志伟
     * 时   间: 2022/9/22 16:35
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;
    /**
     * 属性描述: 创建时间
     * 作   者: 谭志伟
     * 时   间: 2022/9/22 16:35
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 属性描述: 更新者
     * 作   者: 谭志伟
     * 时   间: 2022/9/22 16:35
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
    /**
     * 属性描述: 更新时间
     * 作   者: 谭志伟
     * 时   间: 2022/9/22 16:35
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
