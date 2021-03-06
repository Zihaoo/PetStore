package com.newer.petstore.domain;

import java.math.BigDecimal;

/**
 * 订单项
 * 
 * @author hwyou
 *
 */
public class Item {

	//编号
	private int id;
	//流水号
	private int num;
	//商品
	private Product product;
	//数量
	private int quantity;
	//总价
	private BigDecimal total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
}
