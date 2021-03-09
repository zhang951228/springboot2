package com.erayt.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Z151
 * @Date: 2021/3/3 14:16
 */
@Slf4j
@RestController
public class FEurekaController {

	@Value("${server.port}")
	String port;

	@ResponseBody
	@RequestMapping("pro/{name}")
	public String produce(@RequestParam String name){
		log.info("这里是producer项目，获取到入参: "+name);
		return " hello  "+name+",this is producer"+port+",give you " + Math.random();
	}

	@RequestMapping("proa")
	public String produce(){
		String name = "固定值";
		System.out.println("这里是producer项目，获取到入参: "+name);
		/*		System.out.println("____");*/
		return " hello  "+name+",this is producer"+port+",give you " + Math.random();
	}
}
