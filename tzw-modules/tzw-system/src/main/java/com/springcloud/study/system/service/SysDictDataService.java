package com.springcloud.study.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.study.api.system.bean.po.SysDictData;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.system.bean.req.SysDictDataReq;
import com.springcloud.study.system.bean.req.SysDictTypeReq;
import com.springcloud.study.system.bean.vo.SysDictDataVo;
import com.springcloud.study.system.bean.vo.SysDictTypeVo;

import java.util.List;

/**
 * 类 描 述: 字典数据 服务层
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  10:39
 */
public interface SysDictDataService extends IService<SysDictData> {
    /**
     * 方法描述: 分页查询
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 13:48
     */
    IPage<SysDictDataVo> queryPageDictDataList(SysDictDataReq dictDataReq, PageQuery pageQuery);

    /**
     * 方法描述: 批量删除字典数据信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:52
     */
    void deleteDictDataByIds(String[] dictCodes);

    /**
     * 方法描述: 新增保存字典数据信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:52
     */
    List<SysDictData> insertDictData(SysDictData dictData);

    /**
     * 方法描述: 修改保存字典数据信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:52
     */
    List<SysDictData> updateDictData(SysDictData dictData);
}
