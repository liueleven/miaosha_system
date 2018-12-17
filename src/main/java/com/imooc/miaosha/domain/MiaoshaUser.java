package com.imooc.miaosha.domain;

import lombok.Data;

import java.util.Date;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-16 11:32
 * @author: 十一
 */
@Data
public class MiaoshaUser {
    private Long id;
    private String nickname;
    private String password;
    private String salt;
    private String head;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;
}
