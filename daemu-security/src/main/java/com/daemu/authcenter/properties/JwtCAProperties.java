package com.daemu.authcenter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.stereotype.Component;

/**
 * @Description 类的描述: jwt 证书配置
 * @author daemu
 * @date 2021-01-20 0:24
 */
@Data
@ConfigurationProperties(prefix = "daemu.jwt")
public class JwtCAProperties {

    /**
     * 证书名称
     */
    private String keyPairName;


    /**
     * 证书别名
     */
    private String keyPairAlias;

    /**
     * 证书私钥
     */
    private String keyPairSecret;

    /**
     * 证书存储密钥
     */
    private String keyPairStoreSecret;



}
