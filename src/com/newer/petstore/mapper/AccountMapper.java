package com.newer.petstore.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.newer.petstore.domain.Account;

public interface AccountMapper {
	/**
	 * 创建账号
	 * 
	 * @param account
	 *            账号对象
	 * 
	 */
	@Insert("insert into account(name,password) values(#{name},#{password})")
	void create(Account account);

	/**
	 * 登陆
	 * 
	 * @param user
	 * @return
	 */
	@Select("select * from account where name=#{user}")
	Account login(String user);

	/**
	 * 检查用户名是否存在
	 * 
	 * @param name
	 * @return
	 */
	@Select("select password from account where name=#{name}")
	String checkName(String name);
}
