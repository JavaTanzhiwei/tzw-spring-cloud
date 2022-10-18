package com.springcloud.study.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.core.enums.UserStatus;
import com.springcloud.study.core.exception.user.UserException;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.api.system.bean.po.SysUser;
import com.springcloud.study.system.bean.req.SysUserReq;
import com.springcloud.study.system.bean.vo.SysUserVo;
import com.springcloud.study.system.mapper.SysUserMapper;
import com.springcloud.study.system.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 类 描 述: 用户管理 服务层实现
 * 作   者: 谭志伟
 * 时   间: 2022/9/21  13:37
 */
@RequiredArgsConstructor
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    /**
     * 方法描述: 分页查询
     * 作   者: 谭志伟
     * 时   间: 2022/9/21 13:56
     */
    @Override
    public IPage<SysUserVo> queryPageUserList(SysUserReq userReq, PageQuery pageQuery) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StrUtil.isNotBlank(userReq.getUserName()), SysUser::getUserName, userReq.getUserName());
        return baseMapper.selectVoPage(pageQuery.build(), queryWrapper);
    }

    /**
     * 方法描述: 根据用户编号获取用户详情
     * 作   者: 谭志伟
     * 时   间: 2022/9/22 15:51
     */
    @Override
    public SysUserVo selectVoById(Serializable userId) {
        return baseMapper.selectVoById(userId);
    }

    /**
     * 方法描述: 查询用户信息
     * 作   者: 谭志伟
     * 时   间: 2022/9/27 18:33
     */
    @Override
    public SysUser getUserInfo(String username) throws UserException {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StrUtil.isNotBlank(username), SysUser::getUserName, username);
        SysUser sysUser = baseMapper.selectOne(queryWrapper);
        if (ObjectUtil.isNull(sysUser)) {
            throw new UserException("user.not.exists", username);
        }
        if (UserStatus.DELETED.getCode().equals(sysUser.getDelFlag())) {
            throw new UserException("user.password.delete", username);
        }
        if (UserStatus.DISABLE.getCode().equals(sysUser.getStatus())) {
            throw new UserException("user.blocked", username);
        }
        return sysUser;
    }
}
