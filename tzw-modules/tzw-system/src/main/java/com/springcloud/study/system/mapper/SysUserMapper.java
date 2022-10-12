package com.springcloud.study.system.mapper;

import com.springcloud.study.mybatis.core.mapper.BaseMapperPlus;
import com.springcloud.study.api.system.bean.po.SysUser;
import com.springcloud.study.system.bean.vo.SysUserVo;

/**
 * 类 描 述: 用户管理 数据层
 * 作   者: 谭志伟
 * 时   间: 2022/9/21  13:35
 */
public interface SysUserMapper extends BaseMapperPlus<SysUserMapper, SysUser, SysUserVo> {
}
