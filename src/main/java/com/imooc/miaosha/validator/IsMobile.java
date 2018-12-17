package com.imooc.miaosha.validator;

import com.imooc.miaosha.vo.LoginVo;
import org.hibernate.validator.constraints.Email;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

/**
 * @description: 自定义手机校验注解
 * @date: 2018-12-16 11:48
 * @author: 十一
 */
@Documented
@Constraint(
        validatedBy = {IsMobileValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsMobile {

    // 手机号码格式错误的提示信息
    String message() default "手机号码格式错误";

    boolean required() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
