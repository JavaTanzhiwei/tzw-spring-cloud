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

    /**
     * 方法描述: 根据角色ID查询菜单树信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 14:14
     */
    @Select("<script>" +
            "select m.menu_id  " +
            "from sys_menu m  " +
            "left join sys_role_menu rm on m.menu_id = rm.menu_id  " +
            "where rm.role_id = #{roleId}  " +
            "<if test=\"menuCheckStrictly\">  " +
            "and m.menu_id not in (select m.parent_id from sys_menu m inner join sys_role_menu rm on m.menu_id = rm.menu_id and rm.role_id = #{roleId})  " +
            "</if>  " +
            " order by m.parent_id, m.order_num" +
            "</script>")
    List<String> selectMenuListByRoleId(@Param("roleId") String roleId, @Param("menuCheckStrictly") boolean menuCheckStrictly);

    /**
     * 方法描述: 根据用户ID查询菜单
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 14:17
     */
    @Select("SELECT DISTINCT " +
            "m.id, " +
            "m.parent_id, " +
            "m.menu_name, " +
            "m.path, " +
            "m.component, " +
            "m.visible, " +
            "m.STATUS, " +
            "m.perms, " +
            "m.is_frame, " +
            "m.is_cache, " +
            "m.menu_type, " +
            "m.icon, " +
            "m.order_num, " +
            "m.create_time  " +
            "FROM " +
            "sys_menu m " +
            "LEFT JOIN sys_role_menu rm ON m.id = rm.menu_id " +
            "LEFT JOIN sys_user_role sur ON rm.role_id = sur.role_id " +
            "LEFT JOIN sys_role ro ON sur.role_id = ro.role_id " +
            "LEFT JOIN sys_user u ON sur.user_id = u.user_id  " +
            "WHERE " +
            "u.user_id = #{userId} " +
            "AND m.menu_type IN ( 'M', 'C' )  " +
            "AND m.STATUS = '0'  " +
            "AND ro.STATUS = '0'  " +
            "ORDER BY " +
            "m.parent_id, " +
            "m.order_num")
    List<SysMenu> selectMenuTreeByUserId(String userId);

    /**
     * 方法描述: 根据角色ID查询权限
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 14:25
     */
    @Select("select distinct m.perms " +
            "from sys_menu m " +
            "left join sys_role_menu rm on m.menu_id = rm.menu_id " +
            "where m.status = '0' and rm.role_id = #{roleId}")
    List<String> selectMenuPermsByRoleId(String roleId);

    /**
     * 方法描述: 根据用户ID查询权限
     * 作   者: 谭志伟
     * 时   间: 2022/10/25 14:27
     */
    @Select("select distinct m.perms " +
            "from sys_menu m " +
            "left join sys_role_menu rm on m.menu_id = rm.menu_id " +
            "left join sys_user_role sur on rm.role_id = sur.role_id " +
            "left join sys_role r on r.role_id = sur.role_id " +
            "where m.status = '0' and r.status = '0' and sur.user_id = #{userId}")
    List<String> selectMenuPermsByUserId(String userId);

}
