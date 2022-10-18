package com.springcloud.study.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.study.api.system.bean.po.SysDictData;
import com.springcloud.study.api.system.bean.po.SysDictType;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.system.bean.req.SysDictTypeReq;
import com.springcloud.study.system.bean.vo.SysDictTypeVo;

import java.util.List;

/**
 * 类 描 述: 字典类型 服务层
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  10:39
 */
public interface SysDictTypeService extends IService<SysDictType> {
    /**
     * 方法描述: 分页查询
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:48
     */
    IPage<SysDictTypeVo> queryPageDictTypeList(SysDictTypeReq dictTypeReq, PageQuery pageQuery);

    /**
     * 方法描述: 列表查询 用于导出Excel
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:49
     */
    List<SysDictType> selectDictTypeList(SysDictTypeReq dictTypeReq);

    /**
     * 方法描述: 根据所有字典类型 用于下拉展示
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:50
     */
    List<SysDictType> selectDictTypeAll();

    /**
     * 方法描述: 根据字典类型查询字典数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:50
     */
    List<SysDictData> selectDictDataByType(String dictType);

    /**
     * 方法描述: 批量删除字典信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:51
     */
    void deleteDictTypeByIds(String[] dictIds);

    /**
     * 方法描述: 加载字典缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:52
     */
    void loadingDictCache();

    /**
     * 方法描述: 清空字典缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:52
     */
    void clearDictCache();

    /**
     * 方法描述: 重置字典缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:52
     */
    void resetDictCache();

    /**
     * 方法描述: 新增保存字典类型信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:52
     */
    int insertDictType(SysDictType dictType);

    /**
     * 方法描述: 修改保存字典类型信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:53
     */
    int updateDictType(SysDictType dictType);

    /**
     * 方法描述: 校验字典类型称是否唯一
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:54
     */
    String checkDictTypeUnique(SysDictType dictType);
}
