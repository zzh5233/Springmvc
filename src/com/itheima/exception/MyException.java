package com.itheima.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO 没起作用，不晓得什么情况
 * @author zzh
 */
//@ControllerAdvice
public class MyException{

//	@ExceptionHandler({ArithmeticException.class,ArrayIndexOutOfBoundsException.class})
//	public ModelAndView handlerArithmeticException(Exception e) {
//		
//		ModelAndView mv = new ModelAndView("error");
//		mv.addObject("error",e.getMessage());
//		System.out.println(e + "---------------MyException");
//		return mv;
//	}
}
