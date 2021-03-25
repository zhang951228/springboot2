package com.erayt.single.controller;


import com.erayt.single.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Z151
 * @Date: 2021/3/3 17:50
 */
@Controller
public class pageController {

	@RequestMapping("/wel")
	public String testWel1(){
		System.out.println("调用 testWel1");
		return "index";
	}

	//org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties
	@GetMapping("/wel2")
	public String Wel2(){
		System.out.println("调用wel2");
		return "index";
	}

	@GetMapping("/wel3")
	public String index(Model model) {
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			User u = new User();
			u.setId(i);
			u.setUserName("javaboy:" + i);
			u.setPassword("深圳:" + i);
			users.add(u);
		}
		model.addAttribute("users", users);
		System.out.println("调用wel3");
		return "index";
	}

	@GetMapping(value = "wel4")
	public ModelAndView wel4(HttpServletRequest httpServletRequest){
		System.out.println("调用 wel4");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index.html");
		return modelAndView;
	}

	@RequestMapping(value = "wel5", method = RequestMethod.GET)
	public String show(Model model){
		model.addAttribute("uid","123456789");
		model.addAttribute("name","Jerry");
		return "redirect:/main";
	}

}
