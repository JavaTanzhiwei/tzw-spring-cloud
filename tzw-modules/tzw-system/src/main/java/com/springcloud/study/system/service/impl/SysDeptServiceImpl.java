package com.springcloud.study.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.api.system.bean.po.SysDept;
import com.springcloud.study.system.mapper.SysDeptMapper;
import com.springcloud.study.system.service.SysDeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 类 描 述: 角色管理 服务层
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  13:40
 */
@RequiredArgsConstructor
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {
}
