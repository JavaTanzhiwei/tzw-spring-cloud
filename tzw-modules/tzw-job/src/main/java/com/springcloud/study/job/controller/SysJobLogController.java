package com.springcloud.study.job.controller;

import com.springcloud.study.job.service.SysJobLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类 描 述: 调度任务信息操作控制器
 * 作   者: 谭志伟
 * 时   间: 2022/10/08  11:19
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/job/log")
public class SysJobLogController {
    private final SysJobLogService jobLogService;
}
