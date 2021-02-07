package com.daemu.ums;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: 启动类
 * @author: mumu
 * @create: 2021-02-07 15:46
 **/
@EnableTransactionManagement
@EnableKnife4j
@EnableSwagger2
@SpringBootApplication
@MapperScan(value = "com.daemu.ums.mapper")
public class UmsAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmsAdminApplication.class, args);
    }
}
