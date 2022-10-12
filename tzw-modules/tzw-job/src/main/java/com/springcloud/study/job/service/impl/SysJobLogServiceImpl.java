package com.springcloud.study.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.job.bean.po.SysJobLog;
import com.springcloud.study.job.mapper.SysJobLogMapper;
import com.springcloud.study.job.service.SysJobLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 类 描 述: 定时任务调度日志信息 服务层
 * 作   者: 谭志伟
 * 时   间: 2022/10/08  11:19
 */
@RequiredArgsConstructor
@Service
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogMapper, SysJobLog> implements SysJobLogService {
}
