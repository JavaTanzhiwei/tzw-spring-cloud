package com.springcloud.study.system.controller;

import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.api.system.bean.po.SysOperLogOperation;
import com.springcloud.study.core.base.BaseController;
import com.springcloud.study.system.service.SysOperLogOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类 描 述: 操作日志 控制层
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/sys/log/operation")
public class SysOperLogOperationController extends BaseController {
    private final SysOperLogOperationService operLogOperationService;

    /**
     * 方法描述: 新增操作日志
     * 作   者: 谭志伟
     * 时   间: 2022/9/22 16:17
     */
    @PostMapping
    public AjaxResult save(@RequestBody SysOperLogOperation operLogOperation) {
        return toAjax(operLogOperationService.save(operLogOperation));
    }
}
