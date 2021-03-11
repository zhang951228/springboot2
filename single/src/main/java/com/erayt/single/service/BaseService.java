package com.erayt.single.service;

/**
 * 基础service类
 * @Auther: Z151
 * @Date: 2021/3/11 14:13
 */
public interface BaseService<T> {

	/**
	 * 插入数据
	 * @param record
	 * @return
	 */
	int insert(T record);

	/**
	 * 根据ID,查询出结果
	 * @param id
	 * @return
	 */
	T queryById(Integer id);
}
