package com.springcloud.study.mybatis.hander;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpStatus;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.springcloud.study.api.system.bean.dto.SysUserLoginInfoDto;
import com.springcloud.study.core.base.BasePo;
import com.springcloud.study.core.exception.ServiceException;
import com.springcloud.study.security.utils.LoginHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * 类 描 述: MP注入处理器
 * 作   者: 谭志伟
 * 时   间: 2022/9/22  17:24
 */
@Slf4j
public class CreateAndUpdateMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        try {
            if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof BasePo) {
                BasePo basePo = (BasePo) metaObject.getOriginalObject();
                Date current = ObjectUtil.isNotNull(basePo.getCreateTime())
                        ? basePo.getCreateTime() : new Date();
                basePo.setCreateTime(current);
                basePo.setUpdateTime(current);
                String username = StrUtil.isNotBlank(basePo.getCreateBy())
                        ? basePo.getCreateBy() : getLoginUsername();
                // 当前已登录 且 创建人为空 则填充
                basePo.setCreateBy(username);
                // 当前已登录 且 更新人为空 则填充
                basePo.setUpdateBy(username);
            }
        } catch (Exception e) {
            throw new ServiceException("自动注入异常 => " + e.getMessage(), HttpStatus.HTTP_UNAUTHORIZED);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof BasePo) {
                BasePo basePo = (BasePo) metaObject.getOriginalObject();
                Date current = new Date();
                // 更新时间填充(不管为不为空)
                basePo.setUpdateTime(current);
                String username = getLoginUsername();
                // 当前已登录 更新人填充(不管为不为空)
                if (StrUtil.isNotBlank(username)) {
                    basePo.setUpdateBy(username);
                }
            }
        } catch (Exception e) {
            throw new ServiceException("自动注入异常 => " + e.getMessage(), HttpStatus.HTTP_UNAUTHORIZED);
        }
    }

    /**
     * 获取登录用户名
     * TODO 获取登录的用户信息未完成
     */
    private String getLoginUsername() {
        SysUserLoginInfoDto loginUser;
        try {
            loginUser = LoginHelper.getLoginUser();
        } catch (Exception e) {
            log.warn("自动注入警告 => 用户未登录");
            return null;
        }
        return loginUser.getUserName();
    }
}
