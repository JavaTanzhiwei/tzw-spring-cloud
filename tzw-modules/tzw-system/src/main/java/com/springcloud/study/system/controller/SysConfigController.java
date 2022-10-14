package com.springcloud.study.system.controller;

import com.springcloud.study.core.base.BaseController;
import com.springcloud.study.system.service.SysConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类 描 述: 参数配置 控制层
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  16:37
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/sys/config")
public class SysConfigController extends BaseController {

    private final SysConfigService configService;
}
