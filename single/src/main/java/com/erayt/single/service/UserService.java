package com.erayt.single.service;

import com.erayt.single.domain.User;

/**
 * @Auther: Z151
 * @Date: 2021/3/11 14:12
 */
public interface UserService extends  BaseService<User>{

	/**
	 * 登录
	 * @param username
	 * @param pwd
	 * @return
	 */
	User getUserByUserNamePwd(String username, String pwd);
	/**
	 * 更新用户密码
	 * @param user
	 * @return
	 */
	Integer updatePassword(User user);
}
