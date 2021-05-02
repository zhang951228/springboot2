package com.erayt.analysis.utility;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: Z151
 * @Date: 2021/4/30 11:40
 */
@Slf4j
class JWTUtilTest {

    /**
     * @see JWTUtil#createJWT()
     */
    @Test
    public void createJWT(){
        JWTUtil jwtUtil = new JWTUtil();
        String jwt = jwtUtil.createJWT();
            jwtUtil.decodeJWT(jwt);

    }

    @Test
    public void rsaEncodeTest(){
        JWTUtil jwtUtil = new JWTUtil();
        String rsaEncode = JWTUtil.rsaEncode("123456");
        log.info(rsaEncode);

        String rsaDecode = JWTUtil.rsaDecode(rsaEncode);
        log.info(rsaDecode);
    }
}