package com.daemu.authcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description: 安全中心启动类
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AuthcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthcenterApplication.class, args);
    }
}
