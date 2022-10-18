package com.springcloud.study.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.study.api.system.bean.po.SysOperLogLogin;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.system.bean.req.SysOperLogLoginReq;
import com.springcloud.study.system.bean.vo.SysOperLogLoginVo;

/**
 * 类 描 述: 访问日志 服务层
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
public interface SysOperLogLoginService extends IService<SysOperLogLogin> {
    /**
     * 方法描述: 分页查询
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:58
     */
    IPage<SysOperLogLoginVo> queryPageLoginLogList(SysOperLogLoginReq logLoginReq, PageQuery pageQuery);

    /**
     * 方法描述: 清空系统登录日志
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 15:46
     */
    void cleanLogininfor();
}
