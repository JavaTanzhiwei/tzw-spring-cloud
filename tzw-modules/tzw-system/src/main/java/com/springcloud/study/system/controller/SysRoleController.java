package com.springcloud.study.system.controller;

import com.springcloud.study.core.base.BaseController;
import com.springcloud.study.system.service.SysRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类 描 述: 部门管理 控制层
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  16:42
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends BaseController {

    private final SysRoleService roleService;
}
