package com.itheima.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.domain.Item;

/**
 * 测试，注解的配置方式实现，针对的是方法，一个类中可以有多个方法，实际常用
 * @author zzh
 *
 */
//使用Controller标识它是一个控制器
//@Controller
public class ItemController3{
	
	//商品查询列表
	//使用@RequestMapping实现对queryItem方法和url进行映射，一个方法对应一个url
	//@RequestMapping("/queryItem3")
	public ModelAndView  queryItem() throws Exception {
		
		List<Item> itemList = new ArrayList<Item>();
		Item item1 = new Item();
		item1.setName("香蕉");
		item1.setPrice(12.5f);
		item1.setCreatetime(new Date());
		item1.setDetail("很好吃");
		
		Item item2 = new Item();
		item2.setName("橘子");
		item2.setPrice(15.5f);
		item2.setCreatetime(new Date());
		item2.setDetail("酸酸地");
		
		itemList.add(item1);
		itemList.add(item2);
		
		//返回ModelAndVIew
		ModelAndView modelAndView = new ModelAndView();
		//相当于request.setAttribut，咋jsp页面通过itemsList取数据
		modelAndView.addObject("itemList", itemList);
		
		//指定视图
		modelAndView.setViewName("item/itemList");
		
		return modelAndView;
	}

}
