package com.springcloud.study.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.study.core.exception.user.UserException;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.api.system.bean.po.SysUser;
import com.springcloud.study.system.bean.req.SysUserReq;
import com.springcloud.study.system.bean.vo.SysUserVo;

import java.io.Serializable;

/**
 * 类 描 述: 用户管理 服务层
 * 作   者: 谭志伟
 * 时   间: 2022/9/21  13:36
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 方法描述: 分页查询
     * 作   者: 谭志伟
     * 时   间: 2022/9/21 13:41
     */
    IPage<SysUserVo> queryPageUserList(SysUserReq userReq, PageQuery pageQuery);

    /**
     * 方法描述: 根据用户编号获取用户详情
     * 作   者: 谭志伟
     * 时   间: 2022/9/22 15:51
     */
    SysUserVo selectVoById(Serializable userId);

    /**
     * 方法描述: 查询用户信息
     * 作   者: 谭志伟
     * 时   间: 2022/9/27 17:43
     */
    SysUser getUserInfo(String username) throws UserException;
}
