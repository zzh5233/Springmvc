package com.itheima.service;

import java.util.List;

import com.itheima.domain.Item;
import com.itheima.domain.ItemCustom;
import com.itheima.domain.ItemQueryVo;

/**
 * Item的service接口
 * @author zzh
 *
 */
public interface ItemService {
	
	/**
	 * 查询商品列表 -->
	 * @param itemQueryVo
	 * @return
	 * @throws Exception
	 */
	public List<ItemCustom> findItemList(ItemQueryVo itemQueryVo) throws Exception;
	
	/**
	 * 根据id查找商品 -->
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ItemCustom findItemById(Integer id) throws Exception;
	
	/**
	 * 根据Id更新商品
	 * @param item
	 * @throws Exception
	 */
	public void updateItem(Integer id, ItemCustom itemCustom) throws Exception;
	
	/**
	 * 根据id删除商品
	 * @param id
	 */
	public void removeItem(ItemCustom itemCustom);
	
	public void addItem(Item item) throws Exception;

	
}
