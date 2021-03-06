package com.erayt.dbconnector.repository;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.erayt.dbconnector.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: Z151
 * @Date: 2021/3/12 17:52
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User queryById(String id);
}
