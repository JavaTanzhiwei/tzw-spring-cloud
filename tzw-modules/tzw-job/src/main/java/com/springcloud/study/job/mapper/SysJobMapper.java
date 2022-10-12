package com.springcloud.study.job.mapper;

import com.springcloud.study.job.bean.po.SysJob;
import com.springcloud.study.job.bean.vo.SysJobVo;
import com.springcloud.study.mybatis.core.mapper.BaseMapperPlus;

/**
 * 类 描 述: 调度任务信息 数据层
 * 作   者: 谭志伟
 * 时   间: 2022/10/08  11:19
 */
public interface SysJobMapper extends BaseMapperPlus<SysJobMapper, SysJob, SysJobVo> {
}
