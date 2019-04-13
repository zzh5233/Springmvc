package com.itheima.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.domain.ItemCustom;
import com.itheima.service.ItemService;

/**
 * jackson的测试案例
 * @author zzh
 *
 */
@Controller
public class JacksonTest {

	@Autowired
	private ItemService itemService;
	
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
	
	@RequestMapping("testJson")
	public @ResponseBody List<ItemCustom> testJson(){
		//TODO访问进不去，不晓得什么情况？？
		
		//查询出两个对象封装成一个列表返回
		ItemCustom ic1 = new ItemCustom();
		ic1.setId(1);
		ic1.setName("pingguo");
		ic1.setDetail("haohen");
		ItemCustom ic2 = new ItemCustom();
		ic2.setId(2);
		ic2.setName("juzi");
		ic2.setDetail("bucuo");
		List<ItemCustom> itemCustoms = new ArrayList<>();
		itemCustoms.add(ic1);
		itemCustoms.add(ic2);
		
		return itemCustoms;
	}
	
}
