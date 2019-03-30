package com.itheima.mapper;

import java.util.List;

import com.itheima.domain.ItemCustom;
import com.itheima.domain.ItemQueryVo;

/***
 * Item的mapper接口
 * @author zzh
 *
 */
public interface ItemMapperCustom {
	
	/**
	 * 查询商品列表 -->
	 * @param itemQueryVo
	 * @return
	 * @throws Exception
	 */
	public List<ItemCustom> findItemList(ItemQueryVo itemQueryVo)throws Exception;
	/**
	 *  根据id查找商品 -->
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ItemCustom findItemById(Integer id) throws Exception;
	
	/**
	 * 更新商品信息，里面已有id
	 * @param itemCustom
	 */
	public void updateItem(ItemCustom itemCustom)throws Exception;
	/**
	 * 删除商品
	 * @param itemCustom
	 */
	public void removeItem(ItemCustom itemCustom);
}
