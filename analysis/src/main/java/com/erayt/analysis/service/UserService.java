package com.erayt.analysis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.erayt.analysis.domain.User;

/**
 * @Auther: Z151
 * @Date: 2021/4/1 12:00
 */
public interface UserService extends IService<User> {

    User selectById(Integer id);

    User selectByAccount(String account);
}
