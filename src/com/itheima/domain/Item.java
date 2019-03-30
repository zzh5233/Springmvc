package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.itheima.controller.validation.ValidGroup1;

public class Item implements Serializable {
	private int id;
	
	//校验名称要在1到30字符中间
	//message是只是校验出错显示的信息
	@Size(min=1,max=30,message="{item.name.length.error}",groups= {ValidGroup1.class})
	private String name;
	
	private float price;
	
	private String detail;

	private String pic;
	
	//非空校验
	@NotNull(message="{item.createtime.isNull}")
	private Date createtime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", detail=" + detail + ", pic=" + pic
				+ ", createtime=" + createtime + "]";
	}
}
