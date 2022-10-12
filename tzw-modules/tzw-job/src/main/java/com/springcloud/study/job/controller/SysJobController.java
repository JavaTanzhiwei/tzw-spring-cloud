package com.springcloud.study.job.controller;

import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.core.base.BaseController;
import com.springcloud.study.core.constant.Constants;
import com.springcloud.study.core.exception.job.TaskException;
import com.springcloud.study.core.utils.StringUtils;
import com.springcloud.study.job.bean.po.SysJob;
import com.springcloud.study.job.service.SysJobService;
import com.springcloud.study.job.utils.CronUtils;
import com.springcloud.study.job.utils.ScheduleUtils;
import com.springcloud.study.log.annotation.OperLog;
import com.springcloud.study.log.enums.BusinessType;
import com.springcloud.study.security.utils.LoginHelper;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.*;

/**
 * 类 描 述: 调度任务信息操作控制层
 * 作   者: 谭志伟
 * 时   间: 2022/10/08  11:19
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/job")
public class SysJobController extends BaseController {
    private final SysJobService jobService;

    @OperLog(title = "定时任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysJob job) throws SchedulerException, TaskException {
        if (!CronUtils.isValid(job.getCronExpression())) {
            return AjaxResult.error("新增任务'" + job.getJobName() + "'失败，Cron表达式不正确");
        } else if (StringUtils.containsIgnoreCase(job.getInvokeTarget(), Constants.LOOKUP_RMI)) {
            return AjaxResult.error("新增任务'" + job.getJobName() + "'失败，目标字符串不允许'rmi'调用");
        } else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), new String[]{Constants.LOOKUP_LDAP, Constants.LOOKUP_LDAPS})) {
            return AjaxResult.error("新增任务'" + job.getJobName() + "'失败，目标字符串不允许'ldap(s)'调用");
        } else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), new String[]{Constants.HTTP, Constants.HTTPS})) {
            return AjaxResult.error("新增任务'" + job.getJobName() + "'失败，目标字符串不允许'http(s)'调用");
        } else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), Constants.JOB_ERROR_STR)) {
            return AjaxResult.error("新增任务'" + job.getJobName() + "'失败，目标字符串存在违规");
        } else if (!ScheduleUtils.whiteList(job.getInvokeTarget())) {
            return AjaxResult.error("新增任务'" + job.getJobName() + "'失败，目标字符串不在白名单内");
        }
        job.setCreateBy(LoginHelper.getUsername());
        return toAjax(jobService.save(job));
    }

    /**
     * 定时任务立即执行一次
     */
    @OperLog(title = "定时任务", businessType = BusinessType.UPDATE)
    @PutMapping("/run")
    public AjaxResult run(@RequestBody SysJob job) throws SchedulerException {
        boolean result = jobService.run(job);
        return result ? success() : error("任务不存在或已过期！");
    }
}
