package com.itheima.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.itheima.domain.Item;
/**
 * 测试，继承HttpRequestHandler实现，一个类中一个方法，实际不常用
 * @author zzh
 *
 */
public class ItemController2 implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
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
		
		//原来的servlet的用法，向request域中设置数据
		request.setAttribute("itemList", itemList);
		
		request.getRequestDispatcher("item/itemList").forward(request, response);
	}

}
