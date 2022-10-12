package com.springcloud.study.system;

import com.springcloud.study.core.annotation.EnableFeignTzwClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 类 描 述: 系统模块 启动类
 * 作   者: 谭志伟
 * 时   间: 2022/9/21  10:24
 */
@SpringBootApplication(scanBasePackages = {"com.springcloud.study"})
@EnableFeignTzwClients
@EnableEurekaClient
@Slf4j
public class TzwSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TzwSystemApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)" +
                " _                    \n" +
                "| |_   ____ __      __\n" +
                "| __| |_  / \\ \\ /\\ / /\n" +
                "| |_   / /   \\ V  V / \n" +
                " \\__| /___|   \\_/\\_/ ");
    }
}
