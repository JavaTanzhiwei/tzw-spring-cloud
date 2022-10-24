package com.springcloud.study.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.core.utils.StringUtils;
import com.springcloud.study.security.utils.LoginHelper;
import com.springcloud.study.system.bean.po.SysMenu;
import com.springcloud.study.system.mapper.SysMenuMapper;
import com.springcloud.study.system.service.SysMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类 描 述: 菜单权限 服务层实现
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  16:35
 */
@RequiredArgsConstructor
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    /**
     * 方法描述: 根据用户查询系统菜单列表
     * 作   者: 谭志伟
     * 时   间: 2022/10/24 16:27
     */
    @Override
    public List<SysMenu> selectMenuList(String userId) {
        return selectMenuList(new SysMenu(), userId);
    }

    /**
     * 方法描述: 根据用户查询系统菜单列表
     * 作   者: 谭志伟
     * 时   间: 2022/10/24 16:28
     */
    @Override
    public List<SysMenu> selectMenuList(SysMenu menu, String userId) {
        List<SysMenu> menuList = null;
        // 管理员显示所有菜单信息
        if (LoginHelper.isAdmin(userId)) {
            menuList = baseMapper.selectList(new LambdaQueryWrapper<SysMenu>()
                    .like(StringUtils.isNotBlank(menu.getMenuName()), SysMenu::getMenuName, menu.getMenuName())
                    .eq(StringUtils.isNotBlank(menu.getVisible()), SysMenu::getVisible, menu.getVisible())
                    .eq(StringUtils.isNotBlank(menu.getStatus()), SysMenu::getStatus, menu.getStatus())
                    .orderByAsc(SysMenu::getParentId)
                    .orderByAsc(SysMenu::getOrderNum));
        } else {
            QueryWrapper<SysMenu> wrapper = Wrappers.query();
            wrapper.eq("sur.user_id", userId)
                    .like(StringUtils.isNotBlank(menu.getMenuName()), "m.menu_name", menu.getMenuName())
                    .eq(StringUtils.isNotBlank(menu.getVisible()), "m.visible", menu.getVisible())
                    .eq(StringUtils.isNotBlank(menu.getStatus()), "m.status", menu.getStatus())
                    .orderByAsc("m.parent_id")
                    .orderByAsc("m.order_num");
            menuList = baseMapper.selectMenuListByUserId(wrapper);
        }
        return menuList;
    }
}
