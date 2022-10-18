package com.springcloud.study.system.controller;

import com.springcloud.study.api.system.bean.po.SysDictType;
import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.core.base.BaseController;
import com.springcloud.study.core.constant.UserConstants;
import com.springcloud.study.log.annotation.OperLog;
import com.springcloud.study.log.enums.BusinessType;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.security.utils.LoginHelper;
import com.springcloud.study.system.bean.req.SysDictTypeReq;
import com.springcloud.study.system.service.SysDictTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类 描 述: 字典类型 控制层
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  16:40
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/dict/type")
public class SysDictTypeController extends BaseController {

    private final SysDictTypeService dictTypeService;

    /**
     * 方法描述: 获取字典类型列表
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:43
     */
    @OperLog(title = "获取字典类型列表", businessType = BusinessType.SELECT)
    @GetMapping("/queryPageConfigList")
    public AjaxResult queryPageDictTypeList(SysDictTypeReq dictTypeReq, PageQuery pageQuery) {
        return success(dictTypeService.queryPageDictTypeList(dictTypeReq, pageQuery));
    }

    /**
     * 方法描述: 查询字典类型详细
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:44
     */
    @OperLog(title = "查询字典类型详细", businessType = BusinessType.SELECT)
    @GetMapping("/{dictId}")
    public AjaxResult getDetailDictType(@PathVariable String dictId) {
        return success(dictTypeService.getById(dictId));
    }

    /**
     * 方法描述: 新增字典类型
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:45
     */
    @OperLog(title = "新增字典类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysDictType dict) {
        if (UserConstants.NOT_UNIQUE.equals(dictTypeService.checkDictTypeUnique(dict))) {
            return AjaxResult.error("新增字典'" + dict.getDictName() + "'失败，字典类型已存在");
        }
        return toAjax(dictTypeService.insertDictType(dict));
    }

    /**
     * 方法描述: 修改字典类型
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:45
     */
    @OperLog(title = "修改字典类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysDictType dict) {
        if (UserConstants.NOT_UNIQUE.equals(dictTypeService.checkDictTypeUnique(dict))) {
            return AjaxResult.error("修改字典'" + dict.getDictName() + "'失败，字典类型已存在");
        }
        dict.setUpdateBy(LoginHelper.getUsername());
        return toAjax(dictTypeService.updateDictType(dict));
    }

    /**
     * 方法描述: 删除字典类型
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:46
     */
    @OperLog(title = "字典类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{dictIds}")
    public AjaxResult remove(@PathVariable String[] dictIds) {
        dictTypeService.deleteDictTypeByIds(dictIds);
        return success();
    }

    /**
     * 方法描述: 刷新字典缓存
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:46
     */
    @OperLog(title = "刷新字典缓存", businessType = BusinessType.CLEAN)
    @DeleteMapping("/refreshCache")
    public AjaxResult refreshCache() {
        dictTypeService.resetDictCache();
        return success();
    }

    /**
     * 方法描述: 获取字典选择框列表
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:47
     */
    @GetMapping("/optionselect")
    public AjaxResult optionselect() {
        List<SysDictType> dictTypes = dictTypeService.selectDictTypeAll();
        return success(dictTypes);
    }
}
