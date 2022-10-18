package com.springcloud.study.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.api.system.bean.po.SysDictData;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.security.utils.DictUtils;
import com.springcloud.study.system.bean.req.SysDictDataReq;
import com.springcloud.study.system.bean.vo.SysDictDataVo;
import com.springcloud.study.system.mapper.SysDictDataMapper;
import com.springcloud.study.system.service.SysDictDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 类 描 述: 字典数据 服务层实现
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  13:40
 */
@RequiredArgsConstructor
@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements SysDictDataService {
    /**
     * 方法描述: 分页查询
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:52
     */
    @Override
    public IPage<SysDictDataVo> queryPageDictDataList(SysDictDataReq dictDataReq, PageQuery pageQuery) {
        LambdaQueryWrapper<SysDictData> queryWrapper = new LambdaQueryWrapper<>();
        return baseMapper.selectVoPage(pageQuery.build(), queryWrapper);
    }

    /**
     * 方法描述: 批量删除字典数据信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:52
     */
    @Override
    public void deleteDictDataByIds(String[] dictCodes) {
        Arrays.stream(dictCodes).forEach(item -> {
            SysDictData data = baseMapper.selectById(item);
            baseMapper.deleteById(item);
            List<SysDictData> dictDatas = baseMapper.selectDictDataByType(data.getDictType());
            DictUtils.setDictCache(data.getDictType(), dictDatas);
        });
    }

    /**
     * 方法描述: 新增保存字典数据信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:52
     */
    @Override
    public int insertDictData(SysDictData dictData) {
        int row = baseMapper.insert(dictData);
        if (row > 0) {
            List<SysDictData> dictDatas = baseMapper.selectDictDataByType(dictData.getDictType());
            DictUtils.setDictCache(dictData.getDictType(), dictDatas);
        }
        return row;
    }

    /**
     * 方法描述: 修改保存字典数据信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:52
     */
    @Override
    public int updateDictData(SysDictData dictData) {
        int row = baseMapper.updateById(dictData);
        if (row > 0) {
            List<SysDictData> dictDatas = baseMapper.selectDictDataByType(dictData.getDictType());
            DictUtils.setDictCache(dictData.getDictType(), dictDatas);
        }
        return row;
    }
}
