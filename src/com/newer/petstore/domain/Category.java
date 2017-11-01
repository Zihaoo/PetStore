package com.newer.petstore.domain;

import java.util.LinkedList;
import java.util.List;
/**
 * ���ࣨ���ƣ��ܶ���Ʒ��
 * 
 * @author hwyou
 *
 */
public class Category {

	//���
	private int id;
	
	//���������
	private String title;
	
	//�÷����������Ʒ
	private List<Product> productList = new LinkedList<>();
	
	public Category() {
		// TODO Auto-generated constructor stub
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

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	//ԭ�еķ����һ���µĲ�Ʒ
	public void addProduct(Product product) {
		productList.add(product);
	}
}
