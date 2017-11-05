package com.newer.petstore.domain;

import java.math.BigDecimal;

/**
 * 商品
 * @author hwyou
 *
 */

public class Product extends BaseEntity {
	//编号
	private int id;
	//名称
	private String title;
	//价格
	private BigDecimal price;
	//描述信息
	private String info;
	//库存
	private int quantity;
	//销量
	private int salesNum;
	//图片储存路径
	private String picPath;
	//类别(可选）
	private Category category;
	
	public Product() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSalesNum() {
		return salesNum;
	}
	public void setSalesNum(int salesNum) {
		this.salesNum = salesNum;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", info=" + info + ", quantity="
				+ quantity + ", salesNum=" + salesNum + ", picPath=" + picPath + ", category=" + category + "]";
	}
	
	
}
