package com.newer.petstore.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;

/**
 * ���ﳵ(ǿʵ�壬��ʵ�壩
 * 
 * @author hwyou
 *
 */
public class Cart {
	// ��ϵ�����ݿ������
	private int id;

	private BigDecimal total;

	// ��Ʒ������
	private HashMap<Product, Integer> map = new HashMap<>();

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ���ﳵ�ܽ��
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public HashMap<Product, Integer> getMap() {
		return map;
	}

	public void setMap(HashMap<Product, Integer> map) {
		this.map = map;
	}

}
