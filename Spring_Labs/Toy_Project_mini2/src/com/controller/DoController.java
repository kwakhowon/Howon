package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoController {
	
	@RequestMapping("/index.do")
	public String index(){
		System.out.println("인덱스");
		return "home.index";
	}
	
	@RequestMapping("/signin.do")
	public String Login(){
		return "home.login";
	}
	
	@RequestMapping("/signup.do")
	public String main(){
		return "home.joinForm";
	}
}
