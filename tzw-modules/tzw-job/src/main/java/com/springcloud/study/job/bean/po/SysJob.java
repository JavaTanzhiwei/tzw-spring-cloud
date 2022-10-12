package com.springcloud.study.job.bean.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.springcloud.study.core.base.BasePo;
import com.springcloud.study.core.constant.ScheduleConstants;
import com.springcloud.study.core.utils.StringUtils;
import com.springcloud.study.job.utils.CronUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 类 描 述: 定时任务调度表 sys_job
 * 作   者: 谭志伟
 * 时   间: 2022/10/08  11:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_job")
public class SysJob extends BasePo {
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
     * 属性描述: 执行表达式
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    private String cronExpression;
    /**
     * 属性描述: 计划策略(0=默认,1=立即触发执行,2=触发一次执行,3=不触发立即执行)
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    private String misfirePolicy = ScheduleConstants.MISFIRE_DEFAULT;
    /**
     * 属性描述: 并发执行(0=允许,1=禁止)
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    private String concurrent;
    /**
     * 属性描述: 任务状态(0=正常,1=暂停)
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    private String status;
    /**
     * 属性描述: 下次执行时间
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 13:38
     */
    private Date nextValidTime;

    public Date getNextValidTime() {
        if (StringUtils.isNotEmpty(cronExpression)) {
            return CronUtils.getNextExecution(cronExpression);
        }
        return null;
    }
}
