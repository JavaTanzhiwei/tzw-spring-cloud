package com.springcloud.study.system.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.springcloud.study.api.system.bean.po.SysDictData;
import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.core.base.BaseController;
import com.springcloud.study.log.annotation.OperLog;
import com.springcloud.study.log.enums.BusinessType;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.security.utils.LoginHelper;
import com.springcloud.study.system.bean.req.SysDictDataReq;
import com.springcloud.study.system.service.SysDictDataService;
import com.springcloud.study.system.service.SysDictTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    private final SysDictTypeService dictTypeService;

    /**
     * 方法描述: 获取字典数据列表
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:43
     */
    @OperLog(title = "获取字典数据列表", businessType = BusinessType.SELECT)
    @GetMapping("/queryPageDictDataList")
    public AjaxResult queryPageDictDataList(SysDictDataReq dictDataReq, PageQuery pageQuery) {
        return success(dictDataService.queryPageDictDataList(dictDataReq, pageQuery));
    }

    /**
     * 方法描述: 查询字典数据详细
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:44
     */
    @OperLog(title = "查询字典数据详细", businessType = BusinessType.SELECT)
    @GetMapping("/{dictCode}")
    public AjaxResult getDetailDictData(@PathVariable String dictCode) {
        return success(dictDataService.getById(dictCode));
    }

    /**
     * 方法描述: 根据字典类型查询字典数据信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:58
     */
    @GetMapping(value = "/type/{dictType}")
    public AjaxResult dictType(@PathVariable String dictType) {
        List<SysDictData> data = dictTypeService.selectDictDataByType(dictType);
        if (CollectionUtil.isEmpty(data)) {
            data = new ArrayList<SysDictData>();
        }
        return success(data);
    }

    /**
     * 方法描述: 新增字典数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:59
     */
    @OperLog(title = "新增字典数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysDictData dict) {
        return toAjax(dictDataService.insertDictData(dict));
    }

    /**
     * 方法描述: 修改保存字典数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:59
     */
    @OperLog(title = "修改保存字典数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysDictData dict) {
        dict.setUpdateBy(LoginHelper.getUsername());
        return toAjax(dictDataService.updateDictData(dict));
    }

    /**
     * 方法描述: 删除字典数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 15:00
     */
    @OperLog(title = "删除字典数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{dictCodes}")
    public AjaxResult remove(@PathVariable String[] dictCodes) {
        dictDataService.deleteDictDataByIds(dictCodes);
        return success();
    }
}
