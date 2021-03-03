package com.erayt.producer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Z151
 * @Date: 2021/3/3 14:16
 */
@RestController
public class FEurekaController {

	@Value("${server.port}")
	String port;

	@RequestMapping("pro/{name}")
	public String produce(@RequestParam String name){
		System.out.println("这里是producer项目，获取到入参: "+name);
		System.out.println("____");
		return " hello  "+name+",this is producer"+port+",give you " + Math.random();
	}

	@RequestMapping("proa")
	public String produce(){
		String name = "AAA";
		System.out.println("这里是producer项目，获取到入参: "+name);
		/*		System.out.println("____");*/
		return " hello  "+name+",this is producer"+port+",give you " + Math.random();
	}
}
