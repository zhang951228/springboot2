package com.erayt.analysis.repository;

import com.erayt.analysis.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: Z151
 * @Date: 2021/4/1 15:26
 */
@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper userMapper;
    @Test
    void selectByAccount() {
        System.out.println(1);
        User user = userMapper.selectByAccount("2");
        System.out.println(user);
    }
}