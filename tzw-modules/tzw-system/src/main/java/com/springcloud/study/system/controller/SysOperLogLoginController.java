package com.springcloud.study.system.controller;

import com.springcloud.study.api.system.bean.po.SysOperLogLogin;
import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.core.base.BaseController;
import com.springcloud.study.system.service.SysOperLogLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类 描 述: 用户访问日志 控制层
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/sys/log/login")
public class SysOperLogLoginController extends BaseController {
    private final SysOperLogLoginService operLogLoginService;


    /**
     * 方法描述: 新增访问日志
     * 作   者: 谭志伟
     * 时   间: 2022/9/22 16:17
     */
    @PostMapping
    public AjaxResult save(@RequestBody SysOperLogLogin operLogLogin) {
        return toAjax(operLogLoginService.save(operLogLogin));
    }
}
