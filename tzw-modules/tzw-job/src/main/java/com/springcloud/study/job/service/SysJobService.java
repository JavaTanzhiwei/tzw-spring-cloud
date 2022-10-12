package com.springcloud.study.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.study.core.exception.job.TaskException;
import com.springcloud.study.job.bean.po.SysJob;
import org.quartz.SchedulerException;

/**
 * 类 描 述: 定时任务调度信息信息 服务层
 * 作   者: 谭志伟
 * 时   间: 2022/10/08  11:19
 */
public interface SysJobService extends IService<SysJob> {
    /**
     * 新增任务
     *
     * @param job 调度信息
     * @return 结果
     */
    int insertJob(SysJob job) throws SchedulerException, TaskException;

    /**
     * 更新任务
     *
     * @param job 调度信息
     * @return 结果
     */
    int updateJob(SysJob job) throws SchedulerException, TaskException;

    /**
     * 校验cron表达式是否有效
     *
     * @param cronExpression 表达式
     * @return 结果
     */
    boolean checkCronExpressionIsValid(String cronExpression);

    /**
     * 立即运行任务
     *
     * @param job 调度信息
     * @return 结果
     */
    boolean run(SysJob job) throws SchedulerException;

    /**
     * 任务调度状态修改
     *
     * @param job 调度信息
     * @return 结果
     */
    int changeStatus(SysJob job) throws SchedulerException;

    /**
     * 暂停任务
     *
     * @param job 调度信息
     * @return 结果
     */
    int pauseJob(SysJob job) throws SchedulerException;

    /**
     * 恢复任务
     *
     * @param job 调度信息
     * @return 结果
     */
    int resumeJob(SysJob job) throws SchedulerException;

    /**
     * 删除任务后，所对应的trigger也将被删除
     *
     * @param job 调度信息
     * @return 结果
     */
    int deleteJob(SysJob job) throws SchedulerException;

    /**
     * 批量删除调度信息
     *
     * @param jobIds 需要删除的任务ID
     * @return 结果
     */
    void deleteJobByIds(String[] jobIds) throws SchedulerException;
}
