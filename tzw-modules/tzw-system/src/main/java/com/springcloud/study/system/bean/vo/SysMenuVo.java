package com.springcloud.study.system.bean.vo;

import com.springcloud.study.core.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 类 描 述: 菜单权限表 Vo
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  16:28
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysMenuVo extends BaseVo {
    /**
     * 属性描述: 菜单名称
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:22
     */
    private String menuName;
    /**
     * 属性描述: 父菜单ID
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:22
     */
    private String parentId;
    /**
     * 属性描述: 显示顺序
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:22
     */
    private Integer orderNum;
    /**
     * 属性描述: 路由地址
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:22
     */
    private String path;
    /**
     * 属性描述: 组件路径
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:22
     */
    private String component;
    /**
     * 属性描述: 路由参数
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:22
     */
    private String query;
    /**
     * 属性描述: 是否为外链（0是 1否）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:22
     */
    private String isFrame;
    /**
     * 属性描述: 是否缓存（0缓存 1不缓存）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:22
     */
    private String isCache;
    /**
     * 属性描述: 类型（M目录 C菜单 F按钮）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:22
     */
    private String menuType;
    /**
     * 属性描述: 显示状态（0显示 1隐藏）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:22
     */
    private String visible;
    /**
     * 属性描述: 菜单状态（0显示 1隐藏）
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:22
     */
    private String status;
    /**
     * 属性描述: 权限字符串
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:22
     */
    private String perms;
    /**
     * 属性描述: 菜单图标
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:22
     */
    private String icon;
    /**
     * 属性描述: 备注
     * 作   者: 谭志伟
     * 时   间: 2022/10/14 16:22
     */
    private String remark;
}
