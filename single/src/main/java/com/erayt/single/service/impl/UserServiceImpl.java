package com.erayt.single.service.impl;

import com.erayt.single.domain.User;
import com.erayt.single.event.OnRegistrationCompleteEvent;
import com.erayt.single.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @Auther: Z151
 * @Date: 2021/3/11 14:12
 */
@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Autowired
	ApplicationEventPublisher eventPublisher;

	@Override
	public User queryById(Integer id) {
		return super.queryById(id);
	}

	@Override
	public User getUserByUserNamePwd(String name, String pwd) {
		log.info("用户发起登录请求。当前为UserServiceImpl.getUserByUserNamePwd 方法");
		//只要用户不为zhangsan，都允许登录
		if(!"zhangsan".equals(name)){
			User user = new User();
			user.setUserName(name);
			user.setPassword(pwd);
			return user;
		}
		return null;
	}
	/**
	 * 插入一条数据。
	 * @param record
	 * @return
	 */
	@Override
	public int insert(User record) {
		log.info("调用[UserServiceImpl.insert]方法，入参为："+record);
		//触发其它事件，为将来扩展做准备。
		eventPublisher.publishEvent(new OnRegistrationCompleteEvent(record));
		log.info("调用[UserServiceImpl.insert]方法，入参为："+record +"结束。需注意是否触发了事件。");
		return super.insert(record);
	}


	/**
	 * 更新用户密码
	 * @param user
	 * @return
	 */
	@Override
	public Integer updatePassword(User user) {
		log.info("调用[UserServiceImpl.updatePassword]方法，入参为："+user);
		return null;
	}
}
