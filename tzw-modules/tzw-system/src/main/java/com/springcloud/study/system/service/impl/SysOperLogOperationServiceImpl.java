package com.springcloud.study.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.api.system.bean.po.SysOperLogOperation;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.system.bean.req.SysOperLogOperationReq;
import com.springcloud.study.system.bean.vo.SysOperLogOperationVo;
import com.springcloud.study.system.mapper.SysOperLogOperationMapper;
import com.springcloud.study.system.service.SysOperLogOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 类 描 述: 操作日志 服务层实现
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@RequiredArgsConstructor
@Service
public class SysOperLogOperationServiceImpl extends ServiceImpl<SysOperLogOperationMapper, SysOperLogOperation> implements SysOperLogOperationService {
    /**
     * 方法描述: 分页查询
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 15:15
     */
    @Override
    public IPage<SysOperLogOperationVo> queryPageOperationLogList(SysOperLogOperationReq operationReq, PageQuery pageQuery) {
        LambdaQueryWrapper<SysOperLogOperation> wrapper = new LambdaQueryWrapper();
        return baseMapper.selectVoPage(pageQuery.build(), wrapper);
    }

    /**
     * 方法描述: 清空操作日志
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 15:56
     */
    @Override
    public void cleanOperLog() {
        baseMapper.cleanOperLog();
    }
}
