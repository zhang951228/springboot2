package com.erayt.single.service.impl;

import com.erayt.single.service.BaseService;
import lombok.extern.slf4j.Slf4j;

/**
 * 抽象类实体操作类，
 * @Auther: Z151
 * @Date: 2021/3/11 14:15
 */
@Slf4j
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	@Override
	public int insert(T record) {
		log.info("调用[BaseServiceImpl.insert]方法，入参为："+record);
		return 0;
	}

	@Override
	public T queryById(Integer id) {
		log.info("调用[BaseServiceImpl.queryById]方法，入参为："+id);
		return null;
	}
}
