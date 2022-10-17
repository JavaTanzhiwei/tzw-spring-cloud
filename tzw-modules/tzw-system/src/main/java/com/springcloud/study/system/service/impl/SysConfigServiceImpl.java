package com.springcloud.study.system.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.study.core.constant.CacheConstants;
import com.springcloud.study.core.constant.UserConstants;
import com.springcloud.study.core.utils.StringUtils;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.redis.utils.RedisUtils;
import com.springcloud.study.system.bean.po.SysConfig;
import com.springcloud.study.system.bean.req.SysConfigReq;
import com.springcloud.study.system.bean.vo.SysConfigVo;
import com.springcloud.study.system.mapper.SysConfigMapper;
import com.springcloud.study.system.service.SysConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 类 描 述: 参数配置 服务层
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
    @Override
    public int insertConfig(SysConfig config) {
        int insert = baseMapper.insert(config);
        if (insert > 0) {
            RedisUtils.setCacheObject(getCacheKey(config.getConfigKey()), config.getConfigValue());
        }
        return insert;
    }

    /**
     * 方法描述: 修改参数配置
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:51
     */
    @Override
    public int updateConfig(SysConfig config) {
        int update = baseMapper.updateById(config);
        if (update > 0) {
            RedisUtils.setCacheObject(getCacheKey(config.getConfigKey()), config.getConfigValue());
        }
        return update;
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
            baseMapper.deleteById(item);
            RedisUtils.deleteObject(getCacheKey(config.getConfigKey()));
        });
    }

    /**
     * 方法描述: 根据键名查询参数配置信息
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:45
     */
    @Override
    public String selectConfigByKey(String configKey) {
        String configValue = Convert.toStr(RedisUtils.getCacheObject(getCacheKey(configKey)));
        if (StrUtil.isNotEmpty(configValue)) {
            return configValue;
        }
        LambdaQueryWrapper<SysConfig> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(configKey), SysConfig::getConfigKey, configKey);
        SysConfig retConfig = baseMapper.selectOne(wrapper);
        if (ObjectUtil.isNotNull(retConfig)) {
            RedisUtils.setCacheObject(getCacheKey(configKey), retConfig.getConfigValue());
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
            RedisUtils.setCacheObject(getCacheKey(item.getConfigKey()), item.getConfigValue());
        });
    }

    /**
     * 方法描述: 清空参数缓存数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:27
     */
    @Override
    public void clearConfigCache() {
        Collection<String> keys = RedisUtils.keys(CacheConstants.SYS_CONFIG_KEY + "*");
        RedisUtils.deleteObject(keys);
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

    /**
     * 方法描述: 设施参数配置的Redis的缓存Key
     * 作   者: 谭志伟
     * 时   间: 2022/10/17 14:31
     */
    private String getCacheKey(String configKey) {
        return CacheConstants.SYS_CONFIG_KEY + configKey;
    }
}
