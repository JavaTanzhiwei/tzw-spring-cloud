package com.springcloud.study.system.controller;

import cn.dev33.satoken.secure.BCrypt;
import cn.hutool.core.date.DateUtil;
import com.springcloud.study.common.kafka.config.KafkaConfig;
import com.springcloud.study.common.kafka.utils.KafkaUtils;
import com.springcloud.study.core.api.AjaxResult;
import com.springcloud.study.core.constant.ServiceNameConstants;
import com.springcloud.study.core.constant.UserConstants;
import com.springcloud.study.log.annotation.OperLog;
import com.springcloud.study.log.enums.BusinessType;
import com.springcloud.study.mybatis.core.page.PageQuery;
import com.springcloud.study.api.system.bean.po.SysUser;
import com.springcloud.study.system.bean.req.SysUserReq;
import com.springcloud.study.system.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 类 描 述: 用户管理 控制层
 * 作   者: 谭志伟
 * 时   间: 2022/9/21  13:34
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    private final SysUserService userService;
    private final KafkaConfig kafkaConfig;


    /**
     * 方法描述: 获取用户列表数据
     * 作   者: 谭志伟
     * 时   间: 2022/9/21 14:31
     */
    @OperLog(title = "获取用户列表数据", businessType = BusinessType.SELECT)
    @GetMapping("/queryPageUserList")
    public AjaxResult queryPageUserList(SysUserReq userReq, PageQuery pageQuery) {
        KafkaUtils.sendKafkaServiceMsg("001", kafkaConfig.KAFKA_TZW_TYPE_SYSTEM, "kafka消息队列消费----" + DateUtil.now(), ServiceNameConstants.SYSTEM_SERVICE);
        return AjaxResult.success(userService.queryPageUserList(userReq, pageQuery));
    }

    /**
     * 方法描述: 根据用户编号获取用户详情
     * 作   者: 谭志伟
     * 时   间: 2022/9/22 15:45
     */
    //@OperLog(title = "根据用户编号获取用户详情", businessType = BusinessType.SELECT)
    @GetMapping(value = {"/", "/{userId}"})
    public AjaxResult selectVoById(@PathVariable(value = "userId", required = true) String userId) {
        return AjaxResult.success(userService.selectVoById(userId));
    }

    /**
     * 方法描述: 新增用户
     * 作   者: 谭志伟
     * 时   间: 2022/9/22 16:17
     */
    @OperLog(title = "新增用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult save(@RequestBody SysUser user) {
        user.setPassword(BCrypt.hashpw(UserConstants.password));
        return AjaxResult.success(userService.save(user));
    }

    /**
     * 方法描述: 根据用户名称获取用户信息
     * 作   者: 谭志伟
     * 时   间: 2022/9/28 15:51
     */
    @OperLog(title = "根据用户名称获取用户信息", businessType = BusinessType.SELECT)
    @GetMapping("/getUserInfo")
    public AjaxResult getUserInfo(@RequestParam("username") String username) {
        return AjaxResult.success(userService.getUserInfo(username));
    }

    /**
     * 方法描述: 修改用户
     * 作   者: 谭志伟
     * 时   间: 2022/9/22 16:50
     */
    @OperLog(title = "修改用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysUser user) {
        return AjaxResult.success(userService.updateById(user));
    }

    /**
     * 方法描述: 删除用户
     * 作   者: 谭志伟
     * 时   间: 2022/9/22 16:54
     */
    @OperLog(title = "删除用户", businessType = BusinessType.DELETE)
    @DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable String userIds) {
        return AjaxResult.success(userService.removeBatchByIds(Arrays.asList(userIds.split(","))));
    }
}
