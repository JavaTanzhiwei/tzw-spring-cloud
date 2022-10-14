package com.springcloud.study.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.system.bean.po.SysConfig;
import com.springcloud.study.system.mapper.SysConfigMapper;
import com.springcloud.study.system.service.SysConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 类 描 述: 参数配置 服务层
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  16:35
 */
@RequiredArgsConstructor
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {
}
