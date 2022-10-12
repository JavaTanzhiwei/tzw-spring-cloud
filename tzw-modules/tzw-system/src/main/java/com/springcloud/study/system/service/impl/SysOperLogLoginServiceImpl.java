package com.springcloud.study.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.api.system.bean.po.SysOperLogLogin;
import com.springcloud.study.system.mapper.SysOperLogLoginMapper;
import com.springcloud.study.system.service.SysOperLogLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 类 描 述: 访问日志 服务层
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@RequiredArgsConstructor
@Service
public class SysOperLogLoginServiceImpl extends ServiceImpl<SysOperLogLoginMapper, SysOperLogLogin> implements SysOperLogLoginService {
}
