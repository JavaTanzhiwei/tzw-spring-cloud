package com.springcloud.study.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.study.api.system.bean.po.SysOperLogOperation;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.system.bean.req.SysOperLogOperationReq;
import com.springcloud.study.system.bean.vo.SysOperLogOperationVo;

/**
 * 类 描 述: 操作日志 服务层
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
public interface SysOperLogOperationService extends IService<SysOperLogOperation> {
    /**
     * 方法描述: 分页查询
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:58
     */
    IPage<SysOperLogOperationVo> queryPageOperationLogList(SysOperLogOperationReq operationReq, PageQuery pageQuery);
}
