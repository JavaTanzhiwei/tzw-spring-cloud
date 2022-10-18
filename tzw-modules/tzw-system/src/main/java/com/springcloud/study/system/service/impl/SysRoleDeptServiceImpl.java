package com.springcloud.study.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.system.bean.po.SysRoleDept;
import com.springcloud.study.system.mapper.SysRoleDeptMapper;
import com.springcloud.study.system.service.SysRoleDeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 类 描 述: 角色和部门关联 服务层实现
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  16:16
 */
@RequiredArgsConstructor
@Service
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptMapper, SysRoleDept> implements SysRoleDeptService {
}
