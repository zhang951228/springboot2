package com.erayt.analysis.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.erayt.analysis.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: Z151
 * @Date: 2021/4/1 13:37
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectByAccount(String account);
}
