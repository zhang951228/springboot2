package com.erayt.single.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.erayt.single.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: Z151
 * @Date: 2021/3/25 14:59
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
