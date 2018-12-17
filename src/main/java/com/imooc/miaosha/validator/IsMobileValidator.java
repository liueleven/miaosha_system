package com.imooc.miaosha.validator;

import com.imooc.miaosha.utils.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * @description: 对 @IsMobile注解进行校验
 * @date: 2018-12-16 12:04
 * @author: 十一
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {

    private boolean required = false;

    /**
     *  初始化
     * @param isMobile
     */
    @Override
    public void initialize(IsMobile isMobile) {
        // 获取@IsMobile 注解中的required看看值是不是必须的
        required = isMobile.required();
    }

    /**
     * 初始化后进行校验
     * @param s
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(required) {
            // 对手机的格式进行校验
            return ValidatorUtil.isMobile(s);
        }else {
            // 说明可以省略默认值，直接返回true
            if(StringUtils.isEmpty(s)) {
                return true;
            }else {
                // 有值，进行校验
                return ValidatorUtil.isMobile(s);
            }
        }
    }
}
