package com.imooc.miaosha.controller;

import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.redis.RedisConfig;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.redis.UserKey;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.MiaoshaUser;
import com.imooc.miaosha.service.UserService;
import com.imooc.miaosha.vo.LoginVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-14 22:08
 * @author: 十一
 */
@Controller
public class DemoController {

    @Autowired
    private UserService userService;

    @Autowired
    RedisService redisService;


    @RequestMapping("/thymeleaf")
    public String thymeleaf() {
        return "test";
    }

    @RequestMapping("/user/{id}")
    @ResponseBody
    public Result<User> findUser(@PathVariable Integer id) {
        User user = userService.findById(id);
        return new Result<User>(user);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<String> redisGet() {
        String key1 = redisService.get(UserKey.getById,"1", String.class);
        return Result.success(key1);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
        User user = new User(1,"xiao liu");
        boolean f = redisService.set(UserKey.getById,"1",user);
        return Result.success(f);
    }


    @RequestMapping("/validator/email")
    @ResponseBody
    public Result<Boolean> validatorEmail(@RequestParam String email) {
        LoginVo loginVo = new LoginVo();
        loginVo.setEmail(email);

        User user = new User(1,"xiao liu");
        boolean f = redisService.set(UserKey.getById,"1",user);
        return Result.success(f);
    }
}
