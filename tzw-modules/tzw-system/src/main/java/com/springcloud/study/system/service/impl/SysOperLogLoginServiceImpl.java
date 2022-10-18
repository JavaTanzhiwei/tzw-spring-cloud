package com.springcloud.study.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.api.system.bean.po.SysOperLogLogin;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.system.bean.req.SysOperLogLoginReq;
import com.springcloud.study.system.bean.vo.SysOperLogLoginVo;
import com.springcloud.study.system.mapper.SysOperLogLoginMapper;
import com.springcloud.study.system.service.SysOperLogLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 类 描 述: 访问日志 服务层实现
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
@RequiredArgsConstructor
@Service
public class SysOperLogLoginServiceImpl extends ServiceImpl<SysOperLogLoginMapper, SysOperLogLogin> implements SysOperLogLoginService {
    /**
     * 方法描述: 分页查询
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 15:15
     */
    @Override
    public IPage<SysOperLogLoginVo> queryPageLoginLogList(SysOperLogLoginReq logLoginReq, PageQuery pageQuery) {
        LambdaQueryWrapper<SysOperLogLogin> wrapper = new LambdaQueryWrapper();
        return baseMapper.selectVoPage(pageQuery.build(), wrapper);
    }

    /**
     * 方法描述: 清空系统登录日志
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 15:47
     */
    @Override
    public void cleanLogininfor() {
        baseMapper.cleanLogininfor();
    }
}
