package com.erayt.dbconnector;

import com.erayt.dbconnector.domain.User;
import com.erayt.dbconnector.repository.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class DbconnectorApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelect() {
        System.out.println("测试你这样还会乱码嘛");
		System.out.println(("----- selectAll method test ------"));
		User user = userMapper.queryById("1");
		log.info("AAAAAA调用手写内容：user={}",user);
		//selectById
        Object o = userMapper.selectById("1");
        log.info("BBBBB调用mybatis-plus 查询数据。{}",o);
    }
}
