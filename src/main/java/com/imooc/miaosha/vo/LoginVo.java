package com.imooc.miaosha.vo;

import com.imooc.miaosha.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.ConstraintValidator;
import javax.validation.constraints.NotNull;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-16 11:17
 * @author: 十一
 */
@Data
public class LoginVo{

    @NotNull
    @IsMobile(message = "测试手机号码，自定义返回消息")
    private String mobile;

    @NotNull
    @Length(min = 32)
    private String password;

    @Email
    private String email;


}
