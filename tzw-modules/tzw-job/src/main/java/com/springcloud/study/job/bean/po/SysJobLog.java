package com.springcloud.study.job.bean.po;

import com.baomidou.mybatisplus.annotation.*;
import com.springcloud.study.core.base.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 类 描 述: 定时任务调度日志表 sys_job_log
 * 作   者: 谭志伟
 * 时   间: 2022/10/08  11:19
 */
@Data
@TableName("sys_job_log")
public class SysJobLog implements Serializable {
    /**
     * 属性描述: 主键
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;
    /**
     * 属性描述: 任务名称
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    private String jobName;
    /**
     * 属性描述: 任务组名
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    private String jobGroup;
    /**
     * 属性描述: 调用目标字符串
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    private String invokeTarget;
    /**
     * 属性描述: 日志信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    private String jobMessage;
    /**
     * 属性描述: 任务状态(0=正常,1=暂停)
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    private String status;
    /**
     * 属性描述: 异常信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    private String exceptionInfo;
    /**
     * 属性描述: 创建时间
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 属性描述: 开始时间
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    @TableField(exist = false)
    private Date startTime;

    /**
     * 属性描述: 停止时间
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    @TableField(exist = false)
    private Date stopTime;
}
