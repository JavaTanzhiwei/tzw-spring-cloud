package com.springcloud.study.system.controller;

import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.api.system.bean.po.SysOperLogOperation;
import com.springcloud.study.core.base.BaseController;
import com.springcloud.study.log.annotation.OperLog;
import com.springcloud.study.log.enums.BusinessType;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.system.bean.req.SysOperLogOperationReq;
import com.springcloud.study.system.service.SysOperLogOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 类 描 述: 操作日志 控制层
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/log/operation")
public class SysOperLogOperationController extends BaseController {
    private final SysOperLogOperationService operationService;

    /**
     * 方法描述: 获取操作日志列表
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 15:41
     */
    @OperLog(title = "获取操作日志列表", businessType = BusinessType.SELECT)
    @GetMapping("/queryPageOperationLogList")
    public AjaxResult queryPageOperationLogList(SysOperLogOperationReq operationReq, PageQuery pageQuery) {
        return success(operationService.queryPageOperationLogList(operationReq, pageQuery));
    }

    /**
     * 方法描述: 新增操作日志
     * 作   者: 谭志伟
     * 时   间: 2022/9/22 16:17
     */
    @PostMapping
    public AjaxResult save(@RequestBody SysOperLogOperation operLogOperation) {
        return toAjax(operationService.save(operLogOperation));
    }

    /**
     * 方法描述: 批量删除操作日志
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 15:43
     */
    @OperLog(title = "批量删除操作日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{operIds}")
    public AjaxResult remove(@PathVariable String[] operIds) {
        return toAjax(operationService.removeBatchByIds(Arrays.asList(operIds)));
    }

    /**
     * 方法描述: 清空系统操作日志
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 15:44
     */
    @OperLog(title = "清空系统操作日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/clean")
    public AjaxResult clean() {
        operationService.cleanOperLog();
        return success();
    }
}
