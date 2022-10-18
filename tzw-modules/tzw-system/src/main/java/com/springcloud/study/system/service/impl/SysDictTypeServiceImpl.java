package com.springcloud.study.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.api.system.bean.po.SysDictData;
import com.springcloud.study.api.system.bean.po.SysDictType;
import com.springcloud.study.core.constant.UserConstants;
import com.springcloud.study.core.exception.ServiceException;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.security.utils.DictUtils;
import com.springcloud.study.system.bean.req.SysDictTypeReq;
import com.springcloud.study.system.bean.vo.SysDictTypeVo;
import com.springcloud.study.system.mapper.SysDictDataMapper;
import com.springcloud.study.system.mapper.SysDictTypeMapper;
import com.springcloud.study.system.service.SysDictTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
    @Override
    public List<SysDictData> selectDictDataByType(String dictType) {
        List<SysDictData> dictDatas = DictUtils.getDictCache(dictType);
        if (CollectionUtil.isNotEmpty(dictDatas)) {
            return dictDatas;
        }
        dictDatas = dictDataMapper.selectList(new LambdaQueryWrapper<SysDictData>().eq(SysDictData::getDictType, dictType));
        if (CollectionUtil.isNotEmpty(dictDatas)) {
            DictUtils.setDictCache(dictType, dictDatas);
            return dictDatas;
        }
        return null;
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
            baseMapper.deleteById(item);
            DictUtils.removeDictCache(dictType.getDictType());
        });
    }

    /**
     * 方法描述: 加载字典缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public void loadingDictCache() {
        Map<String, List<SysDictData>> dictDataMap = dictDataMapper.selectList(
                new LambdaQueryWrapper<SysDictData>().eq(SysDictData::getStatus, "0"))
                .stream().collect(Collectors.groupingBy(SysDictData::getDictType));
        for (Map.Entry<String, List<SysDictData>> entry : dictDataMap.entrySet()) {
            DictUtils.setDictCache(entry.getKey(), entry.getValue().stream().sorted(Comparator.comparing(SysDictData::getDictSort)).collect(Collectors.toList()));
        }
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
    @Override
    public int insertDictType(SysDictType dictType) {
        int row = baseMapper.insert(dictType);
        if (row > 0) {
            DictUtils.setDictCache(dictType.getDictType(), null);
        }
        return row;
    }

    /**
     * 方法描述: 修改保存字典类型信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:55
     */
    @Override
    public int updateDictType(SysDictType dictType) {
        SysDictType oldDict = baseMapper.selectById(dictType.getId());
        dictDataMapper.updateDictDataType(oldDict.getDictType(), dictType.getDictType());
        int row = baseMapper.updateById(dictType);
        if (row > 0) {
            List<SysDictData> dictDatas = dictDataMapper.selectDictDataByType(dictType.getDictType());
            DictUtils.setDictCache(dictType.getDictType(), dictDatas);
        }
        return row;
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
