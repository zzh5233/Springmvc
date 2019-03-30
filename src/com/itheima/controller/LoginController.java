package com.itheima.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试拦截器的使用
 * @author zzh
 *
 */
@Controller
public class LoginController {

	//登录
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password) {
		
		//调用service进行用户身份验证
		//....
		
		//在session中保存用户身份信息
		session.setAttribute("username", username);
		//重定向到商品列表页面
		return "redirect:/item/queryItem.action";
	}
	//退出
	@RequestMapping("/logout")
	public String logout(HttpSession session,String username,String password) {
		
		//清楚session
		session.invalidate();
		
		//重定向到商品列表页面
		return "redirect:/item/queryItem.action";
	}
	
}
