package com.imooc.miaosha.service;

import com.imooc.miaosha.domain.MiaoshaUserDao;
import com.imooc.miaosha.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-16 11:35
 * @author: 十一
 */
@Service
public class MiaoshaUser {

    @Autowired
    MiaoshaUserDao miaoshaUserDao;

    @Autowired
    RedisService redisService;

    public com.imooc.miaosha.domain.MiaoshaUser getById(long id) {
        return miaoshaUserDao.getById(id);
    }
}
