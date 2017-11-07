package com.newer.petstore.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;

/**
 * 购物车(强实体，弱实体）
 * 
 * @author hwyou
 *
 */
public class Cart {
	//没有持久化，通过计算获得
	private BigDecimal total;

	// 商品，数量
	private HashMap<Product, Integer> map = new HashMap<>();

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	// 重载
	public void addCart(Product product) {
		addCart(product,1);
	}
	
	public void addCart(Product product, int n) {
		map.put(product, n);
	}
	
	
	/**
	 * 购物车总金额
	 * 
	 * @return
	 */
	public BigDecimal getTotal() {
		Set<Product> keys = map.keySet();
		for (Product p : keys) {
			int n = map.get(p);
			total = total.add(p.getPrice().multiply(BigDecimal.valueOf(n)));
		}
		return total;
	}

	public void getSize() {
		
	}



	public HashMap<Product, Integer> getMap() {
		return map;
	}

	public void setMap(HashMap<Product, Integer> map) {
		this.map = map;
	}

}
