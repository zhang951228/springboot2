package com.erayt.single.service.impl;

import com.erayt.single.service.NIOService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import java.beans.Beans;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: Z151
 * @Date: 2021/3/11 11:10
 */
@Slf4j
class NIOServiceImplTest {
	@Autowired
	private NIOService nIOServiceImpl;
	@Test
	void readFile() throws IOException {
		NIOServiceImpl nioService = new NIOServiceImpl();
		StringBuilder stringBuilder = nioService.readFile();
		log.info(stringBuilder.toString());
	}

	@Test
	void writeFile() throws IOException {
		NIOServiceImpl nioService = new NIOServiceImpl();
		nioService.writeFile();
		log.info("ABCD  文件写入完毕");
	}
}