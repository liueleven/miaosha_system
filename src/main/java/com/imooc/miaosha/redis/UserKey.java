package com.imooc.miaosha.redis;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-15 17:28
 * @author: 十一
 */
public class UserKey extends BaseKeyPrefix {

    private UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
