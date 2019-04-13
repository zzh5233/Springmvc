package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class I18nController {
	
	@RequestMapping("testI18n")
	public String testI18n() {
		return "success";
	}
	
}
