package com.erayt.analysis.configuration.spring.security;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: Z151
 * @Date: 2021/4/1 11:23
 */
@Slf4j
@SpringBootTest
class RestDetailsServiceImplTest {

    @Test
    void loadUserByUsername() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        for(int i=0,j=100;i<j;i++){
            String encode = bCryptPasswordEncoder.encode("123456");
            log.info("{}",encode);
        }
    }
}