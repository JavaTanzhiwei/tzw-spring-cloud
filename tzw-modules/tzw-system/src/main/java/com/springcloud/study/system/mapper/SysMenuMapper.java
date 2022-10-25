package com.springcloud.study.system.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.springcloud.study.mybatis.core.mapper.BaseMapperPlus;
import com.springcloud.study.system.bean.po.SysMenu;
import com.springcloud.study.system.bean.vo.SysMenuVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 类 描 述: 菜单权限 数据层
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  16:32
 */
public interface SysMenuMapper extends BaseMapperPlus<SysMenuMapper, SysMenu, SysMenuVo> {
    /**
     * 方法描述: 根据用户查询系统菜单列表
     * 作   者: 谭志伟
     * 时   间: 2022/10/24 16:33
     */
    @Select("select distinct m.menu_id, m.parent_id, m.menu_name, m.path, m.component, m.query_param, m.visible, m.status, " +
            "m.perms, m.is_frame, m.is_cache, m.menu_type, m.icon, m.order_num, m.create_time " +
            "from sys_menu m " +
            "left join sys_role_menu rm on m.menu_id = rm.menu_id " +
            "left join sys_user_role sur on rm.role_id = sur.role_id " +
            "left join sys_role ro on sur.role_id = ro.role_id " +
            "${ew.getCustomSqlSegment}")
    List<SysMenu> selectMenuListByUserId(@Param(Constants.WRAPPER) Wrapper<SysMenu> queryWrapper);
}
