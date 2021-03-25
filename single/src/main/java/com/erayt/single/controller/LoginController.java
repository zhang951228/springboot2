package com.erayt.single.controller;

import com.erayt.single.domain.User;
import com.erayt.single.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: Z151
 * @Date: 2021/3/25 15:01
 */
@Slf4j
@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userServiceImpl){
        this.userService = userServiceImpl;
    }

    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName, @RequestParam("password")  String password, Model model){
        log.info("接收到登录请求：userName={}，password={}",userName,password);
        User user = userService.queryById(Integer.parseInt(userName));
        log.info("查询表中数据结果为：{}" , user);
        if(null == user){
            model.addAttribute("msg","用户名或密码错误。");
            return "index";
        }
        return "main";
    }
}
