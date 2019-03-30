package com.itheima.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor1 implements HandlerInterceptor {

	//进入Handler方法之前执行
	//比如身份认证，身份授权
	//如果认证不通过表示当前用户没有登录，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("HandlerInterceptor1--------"+"preHandle");
		return true;
	}

	//进入Handler方法之后，返回ModelAndView之前执行
	//应用场景是从ModelAndView出发：将公用的模型数据（比如菜单导航）在这里传到视图，也可以在这里统一制定
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor1--------"+"postHandle");
	}
	
	//执行Handler完成执行此方法
	//应用场景：统一异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HandlerInterceptor1--------"+"afterCompletion");
	}

}
