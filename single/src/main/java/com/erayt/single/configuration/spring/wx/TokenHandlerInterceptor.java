package com.erayt.single.configuration.spring.wx;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.erayt.single.utility.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: Z151
 * @Date: 2021/3/26 17:45
 */
@Slf4j
@Component
public class TokenHandlerInterceptor  implements HandlerInterceptor {
    @Value("${erayt.system.tokenType}")
    private String tokenType;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if("2".equals(tokenType)){
            log.info("调用第二种方式校验token，校验header中");
            String token = request.getHeader("token");
            if(!StringUtils.isBlank(token)){
                return false;
            }
            try {
                JWTUtils.verify(token);
            }catch (SignatureVerificationException e){
                e.printStackTrace();
                System.out.println("无效签名");
                return false;
            }catch (TokenExpiredException e){
                e.printStackTrace();
                System.out.println("token过期");
                return false;
            }catch (AlgorithmMismatchException e){
                e.printStackTrace();
                System.out.println("token算法不一致");
                return false;
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("token无效");
                return false;
            }
            return true;
        }

        String token = request.getHeader("token");
        String cookie = request.getHeader("Cookie");
        if(!StringUtils.isBlank(cookie) && cookie.contains("token=")){
            log.info("请求中存在token。");
            //此处需要拿着token去数据库/redis 中校验token合法性。
            return true;
        }
        if (StringUtils.isEmpty(token)) {
            //log.error(String.format("[登录失败] - [%s]其他错误", token), new Exception("登录失败"));
            log.info(String.format("[登录失败] - [%s]其他错误", token));
            return false;
        }
        log.info("请求中存在token。");
        return true;
    }
}
