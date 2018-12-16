package com.imooc.miaosha.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description: jedis封装，主要是怕key覆盖，过期时间等都要考虑到
 * @date: 2018-12-14 23:07
 * @author: 十一
 */
@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;


    /**
     * 设置一个key
     * @param keyPrefix
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(KeyPrefix keyPrefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            // 真正的key
            String realKey = keyPrefix.getPrefix() + key;
            String s = jedis.get(realKey);
            return stringToBean(s,clazz);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            returnToPool(jedis);
        }
        return null;
    }

    /**
     * 设置一个对象
     * @param key
     * @param val
     * @param <T>
     * @return
     */
    public <T> boolean set(KeyPrefix keyPrefix,String key,T val) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = beanToString(val);
            if (str == null || str.length() == 0) {
                return false;
            }
            // 真正的key
            String realKey = keyPrefix.getPrefix() + key;
            // 获取这个key的过期时间
            int expireSeconds = keyPrefix.expireSeconds();
            // 是0就是永不过期
            if(expireSeconds <= 0) {
                jedis.set(realKey,str);
            }else {
                // 将这个key的过期时间设置进去
                jedis.setex(realKey,expireSeconds,str);
            }
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            returnToPool(jedis);
        }
        return false;
    }

    /**
     * 对象转字符串
     * @param val
     * @param <T>
     * @return
     */
    private <T> String beanToString(T val) {
        if(val == null) return null;
        Class<?> clazz = val.getClass();
        if(clazz == int.class || clazz == Integer.class) {
            return val+"";
        }else if(clazz == long.class || clazz == Long.class) {
            return val+"";
        }else {
            return JSON.toJSONString(val);
        }
    }

    /**
     * 字符串转对象
     * @param val
     * @param clazz
     * @param <T>
     * @return
     */
    private <T> T stringToBean(String val,Class<T> clazz) {
        if(val == null) return null;
        if(clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(val);
        }else if(clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(val);
        }else {
            return JSON.toJavaObject(JSON.parseObject(val),clazz);
        }
    }

    /**
     * 关闭资源
     * @param jedis
     */
    private void returnToPool(Jedis jedis) {
        if(jedis != null) {
            jedis.close();
        }
    }


}
