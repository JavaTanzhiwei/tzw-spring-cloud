package com.springcloud.study.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.api.system.bean.po.SysOperLogOperation;
import com.springcloud.study.system.mapper.SysOperLogOperationMapper;
import com.springcloud.study.system.service.SysOperLogOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 类 描 述: 操作日志 服务层
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@RequiredArgsConstructor
@Service
public class SysOperLogOperationServiceImpl extends ServiceImpl<SysOperLogOperationMapper, SysOperLogOperation> implements SysOperLogOperationService {
}
