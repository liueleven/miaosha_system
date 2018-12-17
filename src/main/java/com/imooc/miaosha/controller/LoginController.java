package com.imooc.miaosha.controller;

import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.redis.MiaoshaUserKey;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.utils.UUIDUtil;
import com.imooc.miaosha.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-16 11:11
 * @author: 十一
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    RedisService redisService;

    private static String COOKIE_NAME_TOKEN = "miaosha_token";

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @GetMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "do_login",method = RequestMethod.GET)
    public Result<Boolean> doLogin(HttpServletResponse response,@Valid LoginVo loginVo) {
        logger.info(loginVo.toString());
        // todo 一系列的判断
        if(StringUtils.isEmpty(loginVo.getPassword())) {
            return Result.error(CodeMsg.MOBILE_EMPTY);
        }

        MiaoshaUser user = new MiaoshaUser();
        String token = UUIDUtil.uuid();
        // token放到redis中
        redisService.set(MiaoshaUserKey.token,token,user);
        // token 放到cookie中
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN,token);
        // 设置cookie有效期
        cookie.setMaxAge(MiaoshaUserKey.token.getExpireSeconds());
        // 设置cookie有效路径
        cookie.setPath("/");
        response.addCookie(cookie);
        return null;
    }
}
