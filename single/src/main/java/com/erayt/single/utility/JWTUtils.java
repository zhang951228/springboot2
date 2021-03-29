package com.erayt.single.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.erayt.single.domain.User;

import java.util.Calendar;

public class JWTUtils {

    //获取token
    public static String getToken(User u){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,7); //默认令牌过期时间7天

        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("userId",u.getId())
                .withClaim("username",u.getUserName());

        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(u.getPassword()));
        return token;
    }

    //验证token合法性 成功返回token
    public static DecodedJWT verify(String token){
        //获取登录用户真正的密码假如数据库查出来的是123456
	     String password = "123456";
        JWTVerifier build = JWT.require(Algorithm.HMAC256(password)).build();
        DecodedJWT verify = build.verify(token);
        return verify;
    }
}