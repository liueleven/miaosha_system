package com.imooc.miaosha.redis;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-15 17:28
 * @author: 十一
 */
public class OrderKey extends BaseKeyPrefix {

    public OrderKey(int expireSeconds, String prifix) {
        super(expireSeconds, prifix);
    }
}
