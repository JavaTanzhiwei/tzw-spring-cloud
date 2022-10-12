package com.springcloud.study.job.utils;

import com.springcloud.study.job.bean.po.SysJob;
import org.quartz.JobExecutionContext;

/**
 * 类 描 述: 定时任务处理（允许并发执行）
 * 作   者: 谭志伟
 * 时   间: 2022/10/08  11:19
 */
public class QuartzJobExecution extends AbstractQuartzJob{
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception
    {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
