package com.imooc.miaosha.domain;

import lombok.Data;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-14 22:36
 * @author: 十一
 */
@Data
public class User {

    private Integer id;

    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
