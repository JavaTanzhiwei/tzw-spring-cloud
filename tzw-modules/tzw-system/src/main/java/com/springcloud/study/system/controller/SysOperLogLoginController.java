package com.springcloud.study.system.controller;

import com.springcloud.study.api.system.bean.po.SysOperLogLogin;
import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.core.base.BaseController;
import com.springcloud.study.log.annotation.OperLog;
import com.springcloud.study.log.enums.BusinessType;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.system.bean.req.SysOperLogLoginReq;
import com.springcloud.study.system.service.SysOperLogLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

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
     * 方法描述: 获取登录日志列表
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 15:41
     */
    @OperLog(title = "获取登录日志列表", businessType = BusinessType.SELECT)
    @GetMapping("/queryPageLoginLogList")
    public AjaxResult queryPageLoginLogList(SysOperLogLoginReq logLoginReq, PageQuery pageQuery) {
        return success(operLogLoginService.queryPageLoginLogList(logLoginReq, pageQuery));
    }

    /**
     * 方法描述: 新增访问日志
     * 作   者: 谭志伟
     * 时   间: 2022/9/22 16:17
     */
    @PostMapping
    public AjaxResult save(@RequestBody SysOperLogLogin operLogLogin) {
        return toAjax(operLogLoginService.save(operLogLogin));
    }

    /**
     * 方法描述: 批量删除登录日志
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 15:43
     */
    @OperLog(title = "批量删除登录日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{infoIds}")
    public AjaxResult remove(@PathVariable String[] infoIds) {
        return toAjax(operLogLoginService.removeBatchByIds(Arrays.asList(infoIds)));
    }

    /**
     * 方法描述: 清空系统登录日志
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 15:44
     */
    @OperLog(title = "清空系统登录日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/clean")
    public AjaxResult clean() {
        operLogLoginService.cleanLogininfor();
        return success();
    }
}
