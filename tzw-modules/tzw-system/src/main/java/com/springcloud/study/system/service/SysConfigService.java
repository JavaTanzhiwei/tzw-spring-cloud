package com.springcloud.study.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.system.bean.po.SysConfig;
import com.springcloud.study.system.bean.vo.SysConfigVo;

/**
 * 类 描 述: 参数配置 服务层
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  16:33
 */
public interface SysConfigService extends IService<SysConfig> {
    /**
     * 方法描述: 分页查询
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:58
     */
    IPage<SysConfigVo> queryPageConfigList(SysConfig configReq, PageQuery pageQuery);

    /**
     * 方法描述: 新增参数配置
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:50
     */
    int insertConfig(SysConfig config);

    /**
     * 方法描述: 修改参数配置
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:50
     */
    int updateConfig(SysConfig config);

    /**
     * 方法描述: 批量删除参数信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:50
     */
    void deleteConfigByIds(String[] configIds);

    /**
     * 方法描述: 根据键名查询参数配置信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:45
     */
    String selectConfigByKey(String configKey);

    /**
     * 方法描述: 加载参数缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:27
     */
    void loadingConfigCache();

    /**
     * 方法描述: 清空参数缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:27
     */
    void clearConfigCache();

    /**
     * 方法描述: 重置参数缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:27
     */
    void resetConfigCache();

    /**
     * 方法描述: 校验参数键名是否唯一
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:27
     */
    String checkConfigKeyUnique(SysConfig config);
}
