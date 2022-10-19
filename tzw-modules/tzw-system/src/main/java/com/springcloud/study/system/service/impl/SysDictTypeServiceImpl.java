package com.springcloud.study.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.api.system.bean.po.SysDictData;
import com.springcloud.study.api.system.bean.po.SysDictType;
import com.springcloud.study.core.constant.CacheConstants;
import com.springcloud.study.core.constant.UserConstants;
import com.springcloud.study.core.exception.ServiceException;
import com.springcloud.study.core.utils.StreamUtils;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.security.utils.DictUtils;
import com.springcloud.study.system.bean.req.SysDictTypeReq;
import com.springcloud.study.system.bean.vo.SysDictTypeVo;
import com.springcloud.study.system.mapper.SysDictDataMapper;
import com.springcloud.study.system.mapper.SysDictTypeMapper;
import com.springcloud.study.system.service.SysDictTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 类 描 述: 字典类型 服务层实现
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  13:40
 */
@RequiredArgsConstructor
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements SysDictTypeService {
    private final SysDictDataMapper dictDataMapper;

    /**
     * 方法描述: 项目启动时，初始化字典到缓存
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:39
     */
    @PostConstruct
    public void init() {
        loadingDictCache();
    }

    /**
     * 方法描述: 分页查询
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public IPage<SysDictTypeVo> queryPageDictTypeList(SysDictTypeReq dictTypeReq, PageQuery pageQuery) {
        LambdaQueryWrapper<SysDictType> queryWrapper = new LambdaQueryWrapper<>();
        return baseMapper.selectVoPage(pageQuery.build(), queryWrapper);
    }

    /**
     * 方法描述: 列表查询 用于导出Excel
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public List<SysDictType> selectDictTypeList(SysDictTypeReq dictTypeReq) {
        LambdaQueryWrapper<SysDictType> queryWrapper = new LambdaQueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    /**
     * 方法描述: 根据所有字典类型 用于下拉展示
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public List<SysDictType> selectDictTypeAll() {
        return baseMapper.selectList();
    }

    /**
     * 方法描述: 根据字典类型查询字典数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Cacheable(cacheNames = CacheConstants.SYS_DICT, key = "#dictType")
    @Override
    public List<SysDictData> selectDictDataByType(String dictType) {
        return dictDataMapper.selectDictDataByType(dictType);
    }

    /**
     * 方法描述: 批量删除字典信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public void deleteDictTypeByIds(String[] dictIds) {
        Arrays.stream(dictIds).forEach(item -> {
            SysDictType dictType = baseMapper.selectById(item);
            if (dictDataMapper.countDictDataByType(dictType.getDictType()) > 0) {
                throw new ServiceException(String.format("%1$s已分配,不能删除", dictType.getDictName()));
            }
            DictUtils.removeDictCache(dictType.getDictType());
        });
        baseMapper.deleteBatchIds(Arrays.asList(dictIds));
    }

    /**
     * 方法描述: 加载字典缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public void loadingDictCache() {
        List<SysDictData> dictDataList = dictDataMapper.selectList(
                new LambdaQueryWrapper<SysDictData>().eq(SysDictData::getStatus, UserConstants.DICT_NORMAL));
        Map<String, List<SysDictData>> dictDataMap = StreamUtils.groupByKey(dictDataList, SysDictData::getDictType);
        dictDataMap.forEach((k, v) -> {
            List<SysDictData> dictList = StreamUtils.sorted(v, Comparator.comparing(SysDictData::getDictSort));
            DictUtils.setDictCache(k, dictList);
        });
    }

    /**
     * 方法描述: 清空字典缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public void clearDictCache() {
        DictUtils.clearDictCache();
    }

    /**
     * 方法描述: 重置字典缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public void resetDictCache() {
        clearDictCache();
        loadingDictCache();
    }

    /**
     * 方法描述: 新增保存字典类型信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @CachePut(cacheNames = CacheConstants.SYS_DICT, key = "#dict.dictType")
    @Override
    public List<SysDictData> insertDictType(SysDictType dict) {
        int row = baseMapper.insert(dict);
        if (row > 0) {
            return new ArrayList<>();
        }
        throw new ServiceException("操作失败");
    }

    /**
     * 方法描述: 修改保存字典类型信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @CachePut(cacheNames = CacheConstants.SYS_DICT, key = "#dict.dictType")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<SysDictData> updateDictType(SysDictType dict) {
        SysDictType oldDict = baseMapper.selectById(dict.getId());
        dictDataMapper.updateDictDataType(oldDict.getDictType(), dict.getDictType());
        int row = baseMapper.updateById(dict);
        if (row > 0) {
            DictUtils.removeDictCache(oldDict.getDictType());
            return dictDataMapper.selectDictDataByType(dict.getDictType());
        }
        throw new ServiceException("操作失败");
    }

    /**
     * 方法描述: 校验字典类型称是否唯一
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public String checkDictTypeUnique(SysDictType dictType) {
        String dictId = dictType.getId();
        // 校验是否唯一Key
        LambdaQueryWrapper<SysDictType> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(dictType.getDictType()), SysDictType::getDictType, dictType.getDictType());
        SysDictType sysDictType = baseMapper.selectOne(wrapper);
        if (ObjectUtil.isNotNull(sysDictType) && dictType.getId() != dictId) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }
}
