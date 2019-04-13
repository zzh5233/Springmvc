package com.itheima.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="数组下标越界222！！！")
public class MyArrayIndexOutOfBoundsException extends Exception{
	
}
