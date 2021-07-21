package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PhoneController {
	//필드
	
	//생성자
	
	//g/s method
	
	//general method
	@RequestMapping(value="/test")
	public String test() {
		System.out.println("test");
		
		return "/WEB-INF/views/test.jsp";
	}
	
	
}
