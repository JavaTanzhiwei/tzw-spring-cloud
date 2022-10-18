package com.springcloud.study.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.api.system.bean.po.SysDictData;
import com.springcloud.study.api.system.bean.po.SysDictType;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.system.bean.req.SysDictTypeReq;
import com.springcloud.study.system.bean.vo.SysDictTypeVo;
import com.springcloud.study.system.mapper.SysDictTypeMapper;
import com.springcloud.study.system.service.SysDictTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类 描 述: 字典类型 服务层实现
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  13:40
 */
@RequiredArgsConstructor
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements SysDictTypeService {
    /**
     * 方法描述: 分页查询
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public IPage<SysDictTypeVo> queryPageDictTypeList(SysDictTypeReq dictTypeReq, PageQuery pageQuery) {
        return null;
    }

    /**
     * 方法描述: 列表查询 用于导出Excel
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public List<SysDictType> selectDictTypeList(SysDictTypeReq dictTypeReq) {
        return null;
    }

    /**
     * 方法描述: 根据所有字典类型 用于下拉展示
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public List<SysDictType> selectDictTypeAll() {
        return null;
    }

    /**
     * 方法描述: 根据字典类型查询字典数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public List<SysDictData> selectDictDataByType(String dictType) {
        return null;
    }

    /**
     * 方法描述: 批量删除字典信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public void deleteDictTypeByIds(String[] dictIds) {

    }

    /**
     * 方法描述: 加载字典缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public void loadingDictCache() {

    }

    /**
     * 方法描述: 清空字典缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public void clearDictCache() {

    }

    /**
     * 方法描述: 重置字典缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public void resetDictCache() {

    }

    /**
     * 方法描述: 新增保存字典类型信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public int insertDictType(SysDictType dictType) {
        return 0;
    }

    /**
     * 方法描述: 修改保存字典类型信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public int updateDictType(SysDictType dictType) {
        return 0;
    }

    /**
     * 方法描述: 校验字典类型称是否唯一
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public String checkDictTypeUnique(SysDictType dictType) {
        return null;
    }
}
