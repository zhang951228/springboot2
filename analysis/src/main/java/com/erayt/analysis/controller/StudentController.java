package com.erayt.analysis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: Z151
 * @Date: 2021/4/2 14:25
 */
@Slf4j
@Controller
@RequestMapping("student")
public class StudentController {
    private final HttpServletResponse response;

    StudentController(HttpServletResponse response){
        this.response = response;
    }


    @RequestMapping("overview")
    public String gotoOverview(){

        log.info("这里给手动设置header");
        response.addHeader("AuthorizationToken","abc");
        return "student/overview";
    }

    @RequestMapping("show")
    public String gotoShow(){
        String header = response.getHeader("AuthorizationToken");
        log.info("从header中尝试获取伪token值：{}",header);
        return "student/show";
    }
}
