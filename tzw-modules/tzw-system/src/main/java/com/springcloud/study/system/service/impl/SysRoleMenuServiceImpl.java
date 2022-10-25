package com.springcloud.study.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.system.bean.po.SysRoleMenu;
import com.springcloud.study.system.mapper.SysRoleMenuMapper;
import com.springcloud.study.system.service.SysRoleMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 类 描 述: 角色和菜单关联 服务层实现
 * 作   者: 谭志伟
 * 时   间: 2022/10/25  13:49
 */
@RequiredArgsConstructor
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {
}
