package com.newer.petstore.domain;

import java.io.Serializable;

/**
 * ����ʵ����Ļ���
 * 
 * @author hwyou
 *
 */
public abstract class BaseEntity implements Serializable {

	/**
	 * ����
	 */
	private int id;

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = id;
	}
}
