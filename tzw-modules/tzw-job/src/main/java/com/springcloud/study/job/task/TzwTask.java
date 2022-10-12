package com.springcloud.study.job.task;

import cn.dev33.satoken.id.SaIdUtil;
import cn.hutool.core.date.DateUtil;
import com.springcloud.study.core.api.AjaxResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 类 描 述: 定时任务业务类
 * 作   者: 谭志伟
 * 时   间: 2022/10/08  11:19
 */
@RequiredArgsConstructor
@Slf4j
@Component("tzwTask")
public class TzwTask {

    /**
     * 方法描述: Id-Token，定时刷新【从0小时开始，每隔2小时（* * 0/2 * * ?）执行一次】
     * 作   者: 谭志伟
     * 时   间: 2022/10/8 11:21
     */
    public void refreshToken() {
        log.info("开始定时刷新【Sa-Token】>>>>>>>>>>>>{}", DateUtil.now());
        SaIdUtil.refreshToken();
        log.info("结束定时刷新【Sa-Token】>>>>>>>>>>>>{}", DateUtil.now());
    }
}
