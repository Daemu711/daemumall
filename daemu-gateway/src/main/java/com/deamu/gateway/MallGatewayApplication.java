package com.deamu.gateway;

import com.deamu.gateway.config.IgnoreUrlsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @description:
 * @author: mumu
 * @create: 2021-09-11 01:13
 **/
@SpringBootApplication
@EnableConfigurationProperties(IgnoreUrlsConfig.class)
public class MallGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallGatewayApplication.class, args);
    }
}