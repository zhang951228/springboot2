package com.erayt.analysis.service.impl;

import com.erayt.analysis.domain.User;
import com.erayt.analysis.repository.UserMapper;
import com.erayt.analysis.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Auther: Z151
 * @Date: 2021/4/1 12:00
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    /**
     * https://docs.spring.io/spring-framework/docs/5.0.3.RELEASE/spring-framework-reference/core.html#beans-constructor-injection
     */
    UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    /**
     * 根据id查询用户身份信息
     * @param id 唯一号
     * @return 返回查询到的客户
     */
    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public User selectByAccount(String account) {
        return userMapper.selectByAccount(account);
    }
}
