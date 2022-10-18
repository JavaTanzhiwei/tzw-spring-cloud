package com.springcloud.study.system.mapper;

import com.springcloud.study.mybatis.core.mapper.BaseMapperPlus;
import com.springcloud.study.api.system.bean.po.SysOperLogOperation;
import com.springcloud.study.system.bean.vo.SysOperLogOperationVo;
import org.apache.ibatis.annotations.Update;

/**
 * 类 描 述: 操作日志 数据层
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  15:19
 */
public interface SysOperLogOperationMapper extends BaseMapperPlus<SysOperLogOperationMapper, SysOperLogOperation, SysOperLogOperationVo> {
    /**
     * 方法描述: 清空操作日志
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 15:56
     */
    @Update("truncate table sys_oper_log_operation")
    void cleanOperLog();
}
