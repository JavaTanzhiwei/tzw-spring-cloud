package com.springcloud.study.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 类 描 述: GateWay 模块启动类
 * 作   者: 谭志伟
 * 时   间: 2022/9/28  16:17
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@Slf4j
public class TzwGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TzwGateWayApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  GateWay模块启动成功   ლ(´ڡ`ლ)" +
                " _                    \n" +
                "| |_   ____ __      __\n" +
                "| __| |_  / \\ \\ /\\ / /\n" +
                "| |_   / /   \\ V  V / \n" +
                " \\__| /___|   \\_/\\_/ ");
    }
}
