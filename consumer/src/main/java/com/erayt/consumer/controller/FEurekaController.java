package com.erayt.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;

/**
 * @Auther: Z151
 * @Date: 2021/3/3 14:43
 */
@Slf4j
@RestController
public class FEurekaController {

	@Autowired
	public RestTemplate restTemplate;

	@RequestMapping("/t1")
	public String testEureka(){
		log.info("调用消费者方法，传入参数：");
		String forObject = restTemplate.getForObject("http://producer1/proa", String.class);
		log.info(forObject);
		return forObject;
	}

	@RequestMapping("/t2/{name}")
	public String testEureka2(@PathParam("name") String name){
		log.info("调用消费者方法，传入参数："+name);
		String forObject = restTemplate.getForObject("http://producer1/pro", String.class,name);
		log.info(forObject);
		return forObject;
	}
}
