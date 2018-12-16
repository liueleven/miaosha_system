package com.imooc.miaosha.redis;


import lombok.Data;

/**
 * @description: reids key通用特性的封装
 * @date: 2018-12-15 13:26
 * @author: 十一
 */
@Data
public abstract class BaseKeyPrefix implements KeyPrefix{

    private int expireSeconds;

    private String prefix;

    public BaseKeyPrefix(String prefix) {
        this(0,prefix);
    }

    public BaseKeyPrefix(int expireSeconds, String prifix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prifix;
    }

    /**
     * 0 表示不过期
     * @return
     */
    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();

        return className + ":" + prefix;
    }
}
