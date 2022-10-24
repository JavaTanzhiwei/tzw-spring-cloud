package com.springcloud.study.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.study.system.bean.po.SysMenu;

import java.util.List;

/**
 * 类 描 述: 菜单权限 服务层
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  16:33
 */
public interface SysMenuService extends IService<SysMenu> {
    /**
     * 方法描述: 根据用户查询系统菜单列表
     * 作   者: 谭志伟
     * 时   间: 2022/10/24 16:26
     */
    List<SysMenu> selectMenuList(String userId);

    /**
     * 方法描述: 根据用户查询系统菜单列表
     * 作   者: 谭志伟
     * 时   间: 2022/10/24 16:27
     */
    List<SysMenu> selectMenuList(SysMenu menu, String userId);
}
