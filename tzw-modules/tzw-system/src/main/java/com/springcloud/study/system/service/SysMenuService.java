package com.springcloud.study.system.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.study.system.bean.po.SysMenu;
import com.springcloud.study.system.bean.vo.RouterVo;

import java.util.List;
import java.util.Set;

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

    /**
     * 方法描述: 根据用户ID查询权限
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 13:54
     */
    Set<String> selectMenuPermsByUserId(String userId);

    /**
     * 方法描述: 根据角色ID查询权限
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 13:54
     */
    Set<String> selectMenuPermsByRoleId(String roleId);

    /**
     * 方法描述: 根据用户ID查询菜单树信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 13:55
     */
    List<SysMenu> selectMenuTreeByUserId(String userId);

    /**
     * 方法描述: 根据角色ID查询菜单树信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 13:55
     */
    List<String> selectMenuListByRoleId(String roleId);

    /**
     * 方法描述: 构建前端路由所需要的菜单
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 13:57
     */
    List<RouterVo> buildMenus(List<SysMenu> menus);

    /**
     * 方法描述: 构建前端所需要下拉树结构
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 13:57
     */
    List<Tree<String>> buildMenuTreeSelect(List<SysMenu> menus);

    /**
     * 方法描述: 根据菜单ID查询信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 13:58
     */
    SysMenu selectMenuById(String menuId);

    /**
     * 方法描述: 是否存在菜单子节点
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 13:58
     */
    boolean hasChildByMenuId(String menuId);

    /**
     * 方法描述: 查询菜单是否存在角色
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 13:58
     */
    boolean checkMenuExistRole(String menuId);

    /**
     * 方法描述: 校验菜单名称是否唯一
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 13:59
     */
    String checkMenuNameUnique(SysMenu menu);
}
