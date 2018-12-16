package com.imooc.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-15 13:16
 * @author: 十一
 */
@Service
public class RedisPoolFactory {

    @Autowired
    private RedisConfig redisConfig;

    @Bean
    public JedisPool jedisFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(redisConfig.getMaxIdle());
//        jedisPoolConfig.setMaxTotal(redisConfig.getMaxTotal());
//        jedisPoolConfig.setMaxWaitMillis(redisConfig.getMaxWait() * 1000);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,redisConfig.getHost(),redisConfig.getPort(),
                redisConfig.getTimeout() * 1000,redisConfig.getPassword(),0);
        return jedisPool;
    }
}
