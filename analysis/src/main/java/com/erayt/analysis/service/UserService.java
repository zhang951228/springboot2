package com.erayt.analysis.service;

import com.erayt.analysis.domain.User;

/**
 * @Auther: Z151
 * @Date: 2021/4/1 12:00
 */
public interface UserService {

    User selectById(Integer id);

    User selectByAccount(String account);
}
