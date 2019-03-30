package com.itheima.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.domain.Item;
import com.itheima.domain.ItemCustom;
import com.itheima.domain.ItemQueryVo;
import com.itheima.mapper.ItemMapperCustom;
import com.itheima.service.ItemService;

public class ItemServiceImpl implements ItemService {

	@Resource(name="itemMapperCustom")
	private ItemMapperCustom itemMapperCustom;
	
	@Override
	public List<ItemCustom> findItemList(ItemQueryVo itemQueryVo) throws Exception {
		return itemMapperCustom.findItemList(itemQueryVo);
	}

	@Override
	public ItemCustom findItemById(Integer id) throws Exception {
		return itemMapperCustom.findItemById(id);
	}
	
	@Override
	public void updateItem(Integer id, ItemCustom itemCustom) throws Exception {
		//添加业务校验，通常在service接口对关键参数进行校验
		//检验id是否为空，若为空抛出异常
			
		itemCustom.setId(id);
		itemMapperCustom.updateItem(itemCustom);
	}
	
	@Override
	public void removeItem(ItemCustom itemCustom) {
		itemMapperCustom.removeItem(itemCustom);
	}
	
	@Override
	public void addItem(Item item) throws Exception {

	}


}
