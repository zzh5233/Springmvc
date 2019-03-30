package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 用来封装Item及自定义的查询条件
 * @author zzh
 *
 */
public class ItemQueryVo implements Serializable {

	private Item item;
	
	private ItemCustom itemCustom;

	//批量的商品的信息
	private List<ItemCustom> itemsList;
	
	//---
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public ItemCustom getItemCustom() {
		return itemCustom;
	}
	public void setItemCustom(ItemCustom itemCustom) {
		this.itemCustom = itemCustom;
	}
	public List<ItemCustom> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<ItemCustom> itemsList) {
		this.itemsList = itemsList;
	}
}
