package com.springcloud.study.auth.service;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import com.springcloud.study.api.system.bean.dto.SysUserLoginInfoDto;
import com.springcloud.study.api.system.feign.RemoteUserService;
import com.springcloud.study.auth.properties.UserPasswordProperties;
import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.core.constant.CacheConstants;
import com.springcloud.study.core.constant.Constants;
import com.springcloud.study.core.enums.DeviceType;
import com.springcloud.study.core.enums.LoginType;
import com.springcloud.study.core.exception.user.UserException;
import com.springcloud.study.core.utils.MessageUtils;
import com.springcloud.study.log.factory.SysUserLoginFactory;
import com.springcloud.study.redis.utils.RedisUtils;
import com.springcloud.study.security.utils.LoginHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.function.Supplier;

/**
 * 类 描 述: 登录校验方法
 * 作   者: 谭志伟
 * 时   间: 2022/9/27  15:39
 */
@RequiredArgsConstructor
@Service
public class SysUserLoginService {
    private final UserPasswordProperties userPasswordProperties;
    private final RemoteUserService remoteUserService;

    /**
     * 登录
     */
    public JSONObject login(String username, String password) {
        JSONObject object = new JSONObject();
        AjaxResult ajaxResult = remoteUserService.getUserInfo(username);
        SysUserLoginInfoDto userInfo = Convert.convert(SysUserLoginInfoDto.class, ajaxResult.get(AjaxResult.DATA_TAG));
        checkLogin(LoginType.PASSWORD, username, () -> !BCrypt.checkpw(password, userInfo.getPassword()));
        // 获取登录token
        LoginHelper.loginByDevice(userInfo, DeviceType.PC);
        // 访问日志
        SysUserLoginFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success"));
        object.putOpt(CacheConstants.SA_TOKEN_NAME, StpUtil.getTokenName());
        object.putOpt(CacheConstants.SA_TOKEN_VALUE, StpUtil.getTokenValue());
        return object;
    }

    /**
     * 退出登录
     */
    public void logout() {
        try {
            String username = LoginHelper.getUsername();
            StpUtil.logout();
            SysUserLoginFactory.recordLogininfor(username, Constants.LOGOUT, MessageUtils.message("user.logout.success"));
        } catch (NotLoginException e) {
        }
    }


    /**
     * 登录校验
     */
    private void checkLogin(LoginType loginType, String username, Supplier<Boolean> supplier) {
        String errorKey = CacheConstants.PWD_ERR_CNT_KEY + username;
        String loginFail = Constants.LOGIN_FAIL;
        Integer maxRetryCount = userPasswordProperties.getMaxRetryCount();
        Integer lockTime = userPasswordProperties.getLockTime();

        // 获取用户登录错误次数(可自定义限制策略 例如: key + username + ip)
        Integer errorNumber = RedisUtils.getCacheObject(errorKey);
        // 锁定时间内登录 则踢出
        if (ObjectUtil.isNotNull(errorNumber) && errorNumber.equals(maxRetryCount)) {
            SysUserLoginFactory.recordLogininfor(username, loginFail, MessageUtils.message(loginType.getRetryLimitExceed(), maxRetryCount, lockTime));

            throw new UserException(loginType.getRetryLimitExceed(), maxRetryCount, lockTime);
        }

        if (supplier.get()) {
            // 是否第一次
            errorNumber = ObjectUtil.isNull(errorNumber) ? 1 : errorNumber + 1;
            // 达到规定错误次数 则锁定登录
            if (errorNumber.equals(maxRetryCount)) {
                RedisUtils.setCacheObject(errorKey, errorNumber, Duration.ofMinutes(lockTime));
                SysUserLoginFactory.recordLogininfor(username, loginFail, MessageUtils.message(loginType.getRetryLimitExceed(), maxRetryCount, lockTime));
                throw new UserException(loginType.getRetryLimitExceed(), maxRetryCount, lockTime);
            } else {
                // 未达到规定错误次数 则递增
                RedisUtils.setCacheObject(errorKey, errorNumber);
                SysUserLoginFactory.recordLogininfor(username, loginFail, MessageUtils.message(loginType.getRetryLimitCount(), errorNumber));
                throw new UserException(loginType.getRetryLimitCount(), errorNumber);
            }
        }
        // 登录成功 清空错误次数
        RedisUtils.deleteObject(errorKey);
    }
}
