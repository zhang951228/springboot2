package com.erayt.single.virtual;

import com.erayt.single.domain.User;

/**
 * @Auther: Z151
 * @Date: 2021/3/29 16:38
 */
public class VisitUser {
    private static User user = new User();
    static{
        user.setRealName("演示账户_1");
        user.setUserName("visit");
        user.setPassword("123456");
        user.setRole(1);
    }

    /**
     * 获取演示用户
     * @return
     */
    public static User getVisitUser(){

        return user;
    }
}
