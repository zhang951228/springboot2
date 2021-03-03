package com.erayt.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: Z151
 * @Date: 2021/3/3 14:43
 */
@RestController
public class FEurekaController {

	@Autowired
	public RestTemplate restTemplate;

	@RequestMapping("/t1")
	public String testEureka(){
		String forObject = restTemplate.getForObject("http://producer1/proa", String.class);
		System.out.println(forObject);
		return forObject;
	}
}
