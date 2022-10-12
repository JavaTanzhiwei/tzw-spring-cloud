package com.springcloud.study.kafka;

import com.springcloud.study.core.annotation.EnableFeignTzwClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 类 描 述: 消息队列模块 启动类
 * 作   者: 谭志伟
 * 时   间: 2022/10/10  15:46
 */
@SpringBootApplication(scanBasePackages = {"com.springcloud.study"})
@EnableEurekaClient
@EnableFeignTzwClients
@Slf4j
public class TzwKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TzwKafkaApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  消息队列模块启动成功   ლ(´ڡ`ლ)" +
                " _                    \n" +
                "| |_   ____ __      __\n" +
                "| __| |_  / \\ \\ /\\ / /\n" +
                "| |_   / /   \\ V  V / \n" +
                " \\__| /___|   \\_/\\_/ ");
    }
}
