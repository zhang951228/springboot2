package com.erayt.single.controller;

import com.erayt.single.domain.User;
import com.erayt.single.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Z151
 * @Date: 2021/3/11 14:42
 */
@Slf4j
@RestController
@RequestMapping(value="user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}

	public String getUserByUserNamePwd(String username,String password){
		User userByUserNamePwd = userService.getUserByUserNamePwd(username, password);
		return "";
	}

	/**
	 * 插入用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "insert")
	public Map<String,Object> insert(User user){
		log.info("进入user/insert方法 controller");
		Map<String,Object> map = new HashMap<>();
		userService.insert(user);
		log.info("准备退出user/insert方法 controller");
		return map;
	}

	/**
	 * 更新用户密码
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "update")
	public Map<String,Object> updatePassword(User user){
		log.info("进入user/updatePassword方法 controller");
		Map<String,Object> map = new HashMap<>();
		userService.updatePassword(user);
		log.info("准备退出user/updatePassword方法 controller");
		return map;
	}
}
