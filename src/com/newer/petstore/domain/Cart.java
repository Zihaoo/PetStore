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
	//û�г־û���ͨ��������
	private BigDecimal total;

	// ��Ʒ������
	private HashMap<Product, Integer> map = new HashMap<>();

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	// ����
	public void addCart(Product product) {
		addCart(product,1);
	}
	
	public void addCart(Product product, int n) {
		map.put(product, n);
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

	public void getSize() {
		
	}



	public HashMap<Product, Integer> getMap() {
		return map;
	}

	public void setMap(HashMap<Product, Integer> map) {
		this.map = map;
	}

}
