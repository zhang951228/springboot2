package com.erayt.analysis.controller;

import com.erayt.analysis.base.RestResponse;
import com.erayt.analysis.domain.User;
import com.erayt.analysis.event.OnRegistrationCompleteEvent;
import com.erayt.analysis.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Z151
 * @Date: 2021/3/30 14:39
 */
@RestController
@Slf4j
public class RegistController {

    private final UserServiceImpl userServiceImpl;
    private final ApplicationEventPublisher eventPublisher;

    public RegistController(UserServiceImpl userServiceImpl, ApplicationEventPublisher eventPublisher) {
        this.userServiceImpl = userServiceImpl;
        this.eventPublisher = eventPublisher;
    }

    @RequestMapping(value = "/register")
    public RestResponse regist(User user){

        log.info("调用注册用户方法，传入用户信息：{}",user);
        User user1 = userServiceImpl.selectById(user.getId());
        log.info("检查数据库中是否已经存在该用户，查询结果为：{}",user1);
        //1、检验用户账户是否已经存在。
        //插入这次尝试采用xml文件形式插入数据。
        user1 = userServiceImpl.selectByAccount(user1.getAccount());
        log.info("检查数据库中相同accout用户是否存在:{}",user1);

        //OnRegistrationCompleteEvent
        if(1==2){
            return new RestResponse<>(2, "用户已存在");
        }

        //触发事件，告诉用户注册成功了。
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user1));

        return RestResponse.ok();
    }
}
