package com.springcloud.study.auth.controller;

import com.springcloud.study.api.system.bean.dto.SysUserLoginDto;
import com.springcloud.study.auth.service.SysUserLoginService;
import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.core.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 类 描 述: 用户登录控制器集成Sa-token权限认证
 * 作   者: 谭志伟
 * 时   间: 2022/9/21  10:24
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth/user")
public class SaTokenController extends BaseController {
    private final SysUserLoginService userLoginService;

    /**
     * 登录方法
     */
    @PostMapping("/doLogin")
    public AjaxResult doLogin(@Validated @RequestBody SysUserLoginDto form) {
        return success(userLoginService.login(form.getUsername(), form.getPassword()));
    }

    /**
     * 登出方法
     */
    @DeleteMapping("/logout")
    public AjaxResult logout() {
        userLoginService.logout();
        return success();
    }
}
