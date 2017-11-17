package com.newer.petstore.mapper;

import org.apache.ibatis.annotations.Select;

public interface AccountMapper {

	@Select("select password from account where name=#{user}")
	String login(String user);

	/**
	 * ����û����Ƿ����
	 * 
	 * @param name
	 * @return
	 */
	@Select("select password from account where name=#{name}")
	String checkName(String name);
}
