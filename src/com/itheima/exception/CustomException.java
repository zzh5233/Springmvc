package com.itheima.exception;

/**
 * 自定义的异常处理类，发生此类的预期异常，需要从此类中抛出异常
 * @author zzh
 *
 */
public class CustomException extends Exception{

	//异常信息
	public String message;
	
	public CustomException(String message) {
		this.message = message;
	}
	
	//---
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
