package com.newer.petstore.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.newer.petstore.domain.Account;

public interface AccountMapper {
	/**
	 * �����˺�
	 * 
	 * @param account
	 *            �˺Ŷ���
	 * 
	 */
	@Insert("insert into account(name,password) values(#{name},#{password})")
	void create(Account account);

	/**
	 * ��½
	 * 
	 * @param user
	 * @return
	 */
	@Select("select * from account where name=#{user}")
	Account login(String user);

	/**
	 * ����û����Ƿ����
	 * 
	 * @param name
	 * @return
	 */
	@Select("select password from account where name=#{name}")
	String checkName(String name);
}
