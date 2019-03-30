package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.domain.ItemCustom;

/**
 * jackson的测试案例
 * @author zzh
 *
 */
@Controller
public class JacksonTest {

	//请求json串（商品信息）,输出json串（商品信息）
	//@RequestBody将请求的商品的信息json串转换成itemCustom
	//@ResponseBody将itemCustom转换成json输出
	@RequestMapping("/requestJson")
	public @ResponseBody ItemCustom requestJson(@RequestBody ItemCustom itemCustom) {
		//TODO 这个函数就就不来
		
		//@ResponseBody将itemCustom转换成json输出
		return itemCustom;
	}
	
	//请求key/value，输出json
	@RequestMapping("/responseJson")
	public @ResponseBody ItemCustom responseJson(ItemCustom itemCustom) {
		
		//@ResponseBody将itemCustom转换成json输出
		//TODO 回调函数不起什么作用啊？
		return itemCustom;
	}
	
}
