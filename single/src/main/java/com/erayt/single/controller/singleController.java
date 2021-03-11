package com.erayt.single.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Z151
 * @Date: 2021/3/3 17:20
 */
//@RestController
@Slf4j
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
		return "index";
	}

	/**
	 * 测试 异常处理
	 * @return
	 */
	@RequestMapping("/method4")
	public String method4() throws Exception {
		log.info("进入测试异常方法");
		int num1 = 1;
		int num2 = 1;
		int num3 = 11;
		if(1==2){
			throw new RuntimeException("这里是手动抛出异常方法RuntimeException。");
		}
		if(1==1){
			throw new Exception("这里是手动抛出异常方法Exception。");
		}
		int aaa = num1/(num1 - num2);

		log.warn("校验异常方法正常结束。 ,不应该看到该条消息的");

		return "";
	}
}
