package com.springcloud.study.system.controller;

import com.springcloud.study.core.base.BaseController;
import com.springcloud.study.system.service.SysDictDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类 描 述: 字典数据 控制层
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  16:40
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/dict/data")
public class SysDictDataController extends BaseController {

    private final SysDictDataService dictDataService;
}
