package com.springcloud.study.tzwconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 类 描 述: Config 模块启动类
 * 作   者: 谭志伟
 * 时   间: 2022/9/15  15:44
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@Slf4j
public class TzwConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(TzwConfigApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  Config模块启动成功   ლ(´ڡ`ლ)" +
                " _                    \n" +
                "| |_   ____ __      __\n" +
                "| __| |_  / \\ \\ /\\ / /\n" +
                "| |_   / /   \\ V  V / \n" +
                " \\__| /___|   \\_/\\_/ ");
    }
}
