package com.springcloud.study.auth;

import com.springcloud.study.core.annotation.EnableFeignTzwClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 类 描 述: 认证中心 模块启动类
 * 作   者: 谭志伟
 * 时   间: 2022/9/27  15:39
 */
@SpringBootApplication(scanBasePackages = {"com.springcloud.study"})
@EnableEurekaClient
@EnableFeignTzwClients
@Slf4j
public class TzwAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(TzwAuthApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  认证中心模块启动成功   ლ(´ڡ`ლ)" +
                " _                    \n" +
                "| |_   ____ __      __\n" +
                "| __| |_  / \\ \\ /\\ / /\n" +
                "| |_   / /   \\ V  V / \n" +
                " \\__| /___|   \\_/\\_/ ");
    }
}
