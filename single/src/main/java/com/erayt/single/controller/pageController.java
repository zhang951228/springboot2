package com.erayt.single.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Z151
 * @Date: 2021/3/3 17:50
 */
@Controller
public class pageController {

	@RequestMapping("/wel")
	public String testWel1(){
		return "welcome1";
	}
}
