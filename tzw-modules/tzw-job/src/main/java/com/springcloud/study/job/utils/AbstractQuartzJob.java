package com.springcloud.study.job.utils;

import cn.hutool.extra.spring.SpringUtil;
import com.springcloud.study.core.constant.ScheduleConstants;
import com.springcloud.study.core.utils.BeanCopyUtils;
import com.springcloud.study.core.utils.ExceptionUtil;
import com.springcloud.study.core.utils.StringUtils;
import com.springcloud.study.job.bean.po.SysJob;
import com.springcloud.study.job.bean.po.SysJobLog;
import com.springcloud.study.job.service.SysJobLogService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 类 描 述: 抽象quartz调用
 * 作   者: 谭志伟
 * 时   间: 2022/10/08  11:19
 */
@Slf4j
public abstract class AbstractQuartzJob implements Job{
        /**
         * 线程本地变量
         */
        private static ThreadLocal<Date> threadLocal = new ThreadLocal<>();

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            SysJob sysJob = new SysJob();
            BeanCopyUtils.copyBeanProp(sysJob, context.getMergedJobDataMap().get(ScheduleConstants.TASK_PROPERTIES));
            try {
                before(context, sysJob);
                if (sysJob != null) {
                    doExecute(context, sysJob);
                }
                after(context, sysJob, null);
            } catch (Exception e) {
                log.error("任务执行异常  - ：", e);
                after(context, sysJob, e);
            }
        }

        /**
         * 执行前
         *
         * @param context 工作执行上下文对象
         * @param sysJob  系统计划任务
         */
        protected void before(JobExecutionContext context, SysJob sysJob) {
            threadLocal.set(new Date());
        }

        /**
         * 执行后
         *
         * @param context 工作执行上下文对象
         * @param sysJob  系统计划任务
         */
        protected void after(JobExecutionContext context, SysJob sysJob, Exception e) {
            Date startTime = threadLocal.get();
            threadLocal.remove();

            final SysJobLog sysJobLog = new SysJobLog();
            sysJobLog.setJobName(sysJob.getJobName());
            sysJobLog.setJobGroup(sysJob.getJobGroup());
            sysJobLog.setInvokeTarget(sysJob.getInvokeTarget());
            sysJobLog.setStartTime(startTime);
            sysJobLog.setStopTime(new Date());
            long runMs = sysJobLog.getStopTime().getTime() - sysJobLog.getStartTime().getTime();
            sysJobLog.setJobMessage(sysJobLog.getJobName() + " 总共耗时：" + runMs + "毫秒");
            if (e != null) {
                sysJobLog.setStatus("1");
                String errorMsg = StringUtils.substring(ExceptionUtil.getExceptionMessage(e), 0, 2000);
                sysJobLog.setExceptionInfo(errorMsg);
            } else {
                sysJobLog.setStatus("0");
            }

            // 写入数据库当中
            SpringUtil.getBean(SysJobLogService.class).save(sysJobLog);
        }

        /**
         * 执行方法，由子类重载
         *
         * @param context 工作执行上下文对象
         * @param sysJob  系统计划任务
         * @throws Exception 执行过程中的异常
         */
        protected abstract void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception;
}
