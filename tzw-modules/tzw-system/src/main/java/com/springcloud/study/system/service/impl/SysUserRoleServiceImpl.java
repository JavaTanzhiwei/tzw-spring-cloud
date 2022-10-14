package com.springcloud.study.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.system.bean.po.SysUserRole;
import com.springcloud.study.system.mapper.SysUserRoleMapper;
import com.springcloud.study.system.service.SysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 类 描 述: 用户和角色关联 服务层
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  13:53
 */
@RequiredArgsConstructor
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
}
