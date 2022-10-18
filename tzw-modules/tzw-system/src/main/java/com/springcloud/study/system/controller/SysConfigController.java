package com.springcloud.study.system.controller;

import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.core.base.BaseController;
import com.springcloud.study.core.constant.UserConstants;
import com.springcloud.study.log.annotation.OperLog;
import com.springcloud.study.log.enums.BusinessType;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.security.utils.LoginHelper;
import com.springcloud.study.system.bean.po.SysConfig;
import com.springcloud.study.system.service.SysConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 方法描述: 获取参数配置列表
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:56
     */
    @OperLog(title = "获取参数配置列表", businessType = BusinessType.SELECT)
    @GetMapping("/queryPageConfigList")
    public AjaxResult queryPageConfigList(SysConfig configReq, PageQuery pageQuery) {
        return success(configService.queryPageConfigList(configReq, pageQuery));
    }

    /**
     * 方法描述: 根据参数编号获取详细信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 15:04
     */
    @OperLog(title = "获取参数配置列表", businessType = BusinessType.SELECT)
    @GetMapping("/{configId}")
    public AjaxResult getDetailConfig(@PathVariable String configId) {
        return success(configService.getById(configId));
    }

    /**
     * 方法描述: 根据参数键名查询参数值
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 15:04
     */
    @OperLog(title = "根据参数键名查询参数值", businessType = BusinessType.SELECT)
    @GetMapping(value = "/configKey/{configKey}")
    public AjaxResult getConfigKey(@PathVariable String configKey) {
        return success(configService.selectConfigByKey(configKey));
    }

    /**
     * 方法描述: 新增参数配置
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 15:05
     */
    @OperLog(title = "新增参数配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysConfig config) {
        if (UserConstants.NOT_UNIQUE.equals(configService.checkConfigKeyUnique(config))) {
            return error("新增参数'" + config.getConfigName() + "'失败，参数键名已存在");
        }
        return toAjax(configService.insertConfig(config));
    }

    /**
     * 方法描述: 修改参数配置
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 15:07
     */
    @OperLog(title = "修改参数配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysConfig config) {
        if (UserConstants.NOT_UNIQUE.equals(configService.checkConfigKeyUnique(config))) {
            return AjaxResult.error("修改参数'" + config.getConfigName() + "'失败，参数键名已存在");
        }
        config.setUpdateBy(LoginHelper.getUsername());
        return toAjax(configService.updateConfig(config));
    }

    /**
     * 方法描述: 删除参数配置
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 15:08
     */
    @OperLog(title = "删除参数配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{configIds}")
    public AjaxResult remove(@PathVariable String[] configIds) {
        configService.deleteConfigByIds(configIds);
        return success();
    }

    /**
     * 方法描述: 刷新参数缓存
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 15:09
     */
    @OperLog(title = "刷新参数缓存", businessType = BusinessType.CLEAN)
    @DeleteMapping("/refreshCache")
    public AjaxResult refreshCache() {
        configService.resetConfigCache();
        return success();
    }
}
