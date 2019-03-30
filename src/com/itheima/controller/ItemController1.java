package com.itheima.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itheima.domain.Item;
/**
 * 测试，继承controller接口实现，一个类中一个方法，实际不常用
 * @author zzh
 *
 */
public class ItemController1 implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
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
