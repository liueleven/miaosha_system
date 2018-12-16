package com.imooc.miaosha.controller;

import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description: 一定要写注释啊
 * @date: 2018-12-14 01:05
 * @author: 十一
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

//    @GetMapping("/hello")
//    @ResponseBody
//    public Result<String> hello() {
//        return Result.success("hello");
//    }

    @GetMapping("/hello-error")
    @ResponseBody
    public Result<String> error() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/")
    public String testThymeleaf(ModelMap modelMap){
        modelMap.addAttribute("msg", "Hello dalaoyang , this is thymeleaf");
        return "thymeleaf";
    }
}
