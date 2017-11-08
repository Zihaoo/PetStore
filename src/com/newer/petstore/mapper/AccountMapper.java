package com.newer.petstore.mapper;

import org.apache.ibatis.annotations.Select;

public interface AccountMapper {

	@Select("select password from account where name=#{user}")
	String login(String user);
}
