package com.imooc.miaosha.redis;

/**
 * @description: interface -> abstract -> class 模版模式，接口是约定，抽象类中通用的实现，class才是一些特殊的实现
 * redis中key的前缀防止方式覆盖
 * @date: 2018-12-15 13:22
 * @author: 十一
 */
public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}
