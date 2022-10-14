package com.springcloud.study.system.mapper;

import com.springcloud.study.mybatis.core.mapper.BaseMapperPlus;
import com.springcloud.study.system.bean.po.SysUserRole;
import com.springcloud.study.system.bean.vo.SysUserRoleVo;

/**
 * 类 描 述: 用户和角色关联 数据层
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  13:51
 */
public interface SysUserRoleMapper extends BaseMapperPlus<SysUserRoleMapper, SysUserRole, SysUserRoleVo> {
}
