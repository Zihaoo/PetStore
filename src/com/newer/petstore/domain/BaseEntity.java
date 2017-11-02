package com.newer.petstore.domain;

import java.io.Serializable;

/**
 * 所有实体类的基类
 * 
 * @author hwyou
 *
 */
public abstract class BaseEntity implements Serializable {

	/**
	 * 主键
	 */
	private int id;

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = id;
	}
}
