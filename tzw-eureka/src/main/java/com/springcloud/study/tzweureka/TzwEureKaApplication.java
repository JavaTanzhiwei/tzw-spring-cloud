package com.springcloud.study.tzweureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 类 描 述: EureKa 模块启动类
 * 作   者: 谭志伟
 * 时   间: 2022/9/15  15:44
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class TzwEureKaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TzwEureKaApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  EureKa模块启动成功   ლ(´ڡ`ლ)" +
                " _                    \n" +
                "| |_   ____ __      __\n" +
                "| __| |_  / \\ \\ /\\ / /\n" +
                "| |_   / /   \\ V  V / \n" +
                " \\__| /___|   \\_/\\_/ ");
    }

    /**
     * <p>方法描述: springboot引入spring-boot-starter-security做安全校验后，自动开启CSRF安全认证，
     * 任何一次服务请求默认都需要CSRF 的token（自行补脑Spring的CSRF验证），而Eureka-client不会生成该token，故启动时会报如上错误</p>
     * 作   者: 谭志伟
     * 时   间: 2022/9/15 18:03
     */
    @EnableWebSecurity
    static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();
            super.configure(http);
        }
    }
}
