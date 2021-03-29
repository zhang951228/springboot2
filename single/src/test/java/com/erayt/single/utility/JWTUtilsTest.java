package com.erayt.single.utility;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.erayt.single.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: Z151
 * @Date: 2021/3/29 14:59
 */
@Slf4j
class JWTUtilsTest {

    @Test
    public void getToken(){
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");
        user.setId(1);
        String token = JWTUtils.getToken(user);
        log.info("测试程序加密出token为：{}",token);
        DecodedJWT verify = JWTUtils.verify(token);
        log.info(String.valueOf(verify));
    }

}