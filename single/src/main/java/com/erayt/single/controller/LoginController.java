package com.erayt.single.controller;

import com.erayt.single.domain.User;
import com.erayt.single.service.UserService;
import com.erayt.single.utility.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Auther: Z151
 * @Date: 2021/3/25 15:01
 */
@Slf4j
@Controller
public class LoginController {

    @Value("${erayt.demo.userName}")
    private String demoUserName;
    @Value("${erayt.demo.password}")
    private String demoPassword;

    private final UserService userService;

    @Autowired
    public LoginController(UserService userServiceImpl){
        this.userService = userServiceImpl;
    }


    @RequestMapping("/main")
    public String gotoMain(){
        log.info("重定向到main方法。");
        return "main";
    }

    @RequestMapping("/index")
    public String gotoIndex(){
        return "index";
    }

    @RequestMapping("/login")
    public String gotoLogin(){
        return "login";
    }

    @RequestMapping("/register")
    public String gotoRegister(){
        return "register";
    }

    @RequestMapping("/")
    public String gotoIndex2(){
        return "index";
    }

    @PostMapping("/login")
    public String login(HttpServletResponse response,
                        @RequestParam("userName") String userName,
                        @RequestParam("password")  String password){
        log.info("RequestMapping:[login] username is {},password is {}",userName,password);
        //User user = userService.queryById(Integer.parseInt(userName));
        if(demoUserName.equals(userName) && demoPassword.equals(password)){
            log.info("演示账户登录系统咯！");
        }
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");
        user.setId(1);
        String token = JWTUtils.getToken(user);
        log.info("为请求生成token:{}",token);
        response.setHeader("token",token);//JwtUtils.TOKEN_HEADER
        response.setHeader("Set-Cookie", "token="+token);
        return "redirect:/main";
    }

}
