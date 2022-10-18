package com.springcloud.study.system.mapper;

import com.springcloud.study.api.system.bean.po.SysOperLogLogin;
import com.springcloud.study.mybatis.core.mapper.BaseMapperPlus;
import com.springcloud.study.system.bean.vo.SysOperLogLoginVo;
import org.apache.ibatis.annotations.Update;

/**
 * 类 描 述: 访问日志 数据层
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
public interface SysOperLogLoginMapper extends BaseMapperPlus<SysOperLogLoginMapper, SysOperLogLogin, SysOperLogLoginVo> {
    /**
     * 方法描述: 清空系统登录日志
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 15:45
     */
    @Update("truncate table sys_logininfor")
    int cleanLogininfor();
}
