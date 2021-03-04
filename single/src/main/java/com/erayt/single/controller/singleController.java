package com.erayt.single.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Z151
 * @Date: 2021/3/3 17:20
 */
//@RestController
@Controller
public class singleController {


	@RequestMapping("/method1")
	public String method1(){
		System.out.println("method1 成功访问。");
		return "method1 成功访问。";
	}

	@RequestMapping("/method2")
	public String method2(String name){
		System.out.println(name + "method2 成功访问。");
		return name + "method2 成功访问。";
	}

	@RequestMapping("/method3/{name}")
	public String method3(@PathVariable("name") String name ){
		System.out.println(name + "method3 成功访问。");
		//return name + "method3 成功访问。";
		return "welcome1";
	}
}
