package com.imooc.miaosha.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.security.DenyAll;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-14 23:04
 * @author: 十一
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisConfig {

    private String host;

    private Integer port;

    private Integer timeout;

//    private Integer maxIdle;
//
//    private Integer maxTotal;
//
//    private Integer maxWait;

    private String password;



}
