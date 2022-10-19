package com.springcloud.study.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.core.constant.CacheConstants;
import com.springcloud.study.core.constant.UserConstants;
import com.springcloud.study.core.exception.ServiceException;
import com.springcloud.study.core.utils.StringUtils;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.redis.utils.CacheUtils;
import com.springcloud.study.redis.utils.RedisUtils;
import com.springcloud.study.system.bean.po.SysConfig;
import com.springcloud.study.system.bean.req.SysConfigReq;
import com.springcloud.study.system.bean.vo.SysConfigVo;
import com.springcloud.study.system.mapper.SysConfigMapper;
import com.springcloud.study.system.service.SysConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 类 描 述: 参数配置 服务层实现
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  16:35
 */
@RequiredArgsConstructor
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {
    /**
     * 方法描述: 分页查询
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:59
     */
    @Override
    public IPage<SysConfigVo> queryPageConfigList(SysConfigReq configReq, PageQuery pageQuery) {
        LambdaQueryWrapper<SysConfig> queryWrapper = new LambdaQueryWrapper<>();
        return baseMapper.selectVoPage(pageQuery.build(), queryWrapper);
    }

    /**
     * 方法描述: 新增参数配置
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:51
     */
    @CachePut(cacheNames = CacheConstants.SYS_CONFIG, key = "#config.configKey")
    @Override
    public String insertConfig(SysConfig config) {
        int insert = baseMapper.insert(config);
        if (insert > 0) {
            return config.getConfigValue();
        }
        throw new ServiceException("操作失败");
    }

    /**
     * 方法描述: 修改参数配置
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:51
     */
    @CachePut(cacheNames = CacheConstants.SYS_CONFIG, key = "#config.configKey")
    @Override
    public String updateConfig(SysConfig config) {
        int row = 0;
        if (config.getId() != null) {
            row = baseMapper.updateById(config);
        } else {
            row = baseMapper.update(config, new LambdaQueryWrapper<SysConfig>()
                    .eq(SysConfig::getConfigKey, config.getConfigKey()));
        }
        if (row > 0) {
            return config.getConfigValue();
        }
        throw new ServiceException("操作失败");
    }

    /**
     * 方法描述: 批量删除参数信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:51
     */
    @Override
    public void deleteConfigByIds(String[] configIds) {
        Arrays.stream(configIds).forEach(item -> {
            SysConfig config = baseMapper.selectById(item);
            CacheUtils.evict(CacheConstants.SYS_CONFIG, config.getConfigKey());
        });
        baseMapper.deleteBatchIds(Arrays.asList(configIds));
    }

    /**
     * 方法描述: 根据键名查询参数配置信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:45
     */
    @Cacheable(cacheNames = CacheConstants.SYS_CONFIG, key = "#configKey")
    @Override
    public String selectConfigByKey(String configKey) {
        SysConfig retConfig = baseMapper.selectOne(new LambdaQueryWrapper<SysConfig>()
                .eq(SysConfig::getConfigKey, configKey));
        if (ObjectUtil.isNotNull(retConfig)) {
            return retConfig.getConfigValue();
        }
        return StringUtils.EMPTY;
    }

    /**
     * 方法描述: 加载参数缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:27
     */
    @Override
    public void loadingConfigCache() {
        List<SysConfig> configList = baseMapper.selectList();
        configList.stream().forEach(item -> {
            CacheUtils.put(CacheConstants.SYS_CONFIG, item.getConfigKey(), item.getConfigValue());
        });
    }

    /**
     * 方法描述: 清空参数缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:27
     */
    @Override
    public void clearConfigCache() {
        CacheUtils.clear(CacheConstants.SYS_CONFIG);
    }


    /**
     * 方法描述: 重置参数缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:27
     */
    @Override
    public void resetConfigCache() {
        clearConfigCache();
        loadingConfigCache();
    }

    /**
     * 方法描述: 校验参数键名是否唯一
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:27
     */
    @Override
    public String checkConfigKeyUnique(SysConfig config) {
        String configId = config.getId();
        // 校验是否唯一Key
        LambdaQueryWrapper<SysConfig> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(config.getConfigKey()), SysConfig::getConfigKey, config.getConfigKey());
        SysConfig sysConfig = baseMapper.selectOne(wrapper);
        if (ObjectUtil.isNotNull(sysConfig) && sysConfig.getId() != configId) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }
}
