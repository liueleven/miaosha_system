package com.imooc.miaosha.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-16 13:55
 * @author: 十一
 */
public class UUIDUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
