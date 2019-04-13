package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itheima.exception.MyArrayIndexOutOfBoundsException;

@Controller
@RequestMapping("exception")
public class ExceptionController {

	@RequestMapping("testArithmeticException")
	public String testArithmeticException() {
		
		System.out.println( 1/0 );
		return "success";
	}
	@RequestMapping("testArrayIndexOutOfBoundsException")
	public String testArrayIndexOutOfBoundsException() {
		
		byte[] arr = new byte[2];
		System.out.println( arr[3] );
		return "success";
	}
	
//	@ExceptionHandler({ArithmeticException.class,ArrayIndexOutOfBoundsException.class })
//	public String handlerArithmeticException(Exception e) {
//		System.out.println(e + "---------------");
//		return "error";
//	}
	
//	@ExceptionHandler({Exception.class })
//	public String handlerArithmeticException2(Exception e) {
//		System.out.println(e + "---------------22222");
//		return "error";
//	}
	
	@RequestMapping("testMyException")
	public String testMyException(@RequestParam("i") Integer i) throws MyArrayIndexOutOfBoundsException {
		if(i == 3) {
			throw new MyArrayIndexOutOfBoundsException();//抛出异常
		}
		return "success";
	}
	@RequestMapping("testMyException2")
	public String testMyException2(@RequestParam("i") Integer i) {
		if(i == 3) {
			return "redirect:testMyException";
		}
		return "success";
	}
	
	
}
