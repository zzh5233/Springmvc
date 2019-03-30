package com.itheima.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义的全局异常处理器
 * @author zzh
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//hadler就是处理器适配器要执行handerler对象（只有method方法）
		
		CustomException customException = null;
		if(ex instanceof CustomException) {
			customException = (CustomException) ex;
		}else {
			customException = new CustomException("未知错误");
		}
		
		//错误信息
		String message = customException.getMessage();
		
		ModelAndView modelAndView = new ModelAndView();
		
		//将错误信息传到页面
		modelAndView.addObject("message",message);
		
		//指向错误页面
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
