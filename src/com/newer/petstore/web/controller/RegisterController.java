package com.newer.petstore.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.newer.petstore.domain.Account;
import com.newer.petstore.mapper.AccountMapper;
import com.newer.petstore.util.EncodeUtil;

/**
 * ����ע�������
 * 
 * @author hwyou
 *
 */
public class RegisterController implements Controller {
//	
//	//����
//	SqlSession sqlSession;
//
//	/**
//	 * ����ע��
//	 */
//	public void setSqlSession(SqlSession sqlSession) {
//		this.sqlSession = sqlSession;
//	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession)
			throws ServletException, IOException {
		
		System.out.println("register");
		
		String accountName = request.getParameter("account");
		String password = request.getParameter("password");
		
		Account account = new Account();
		account.setName(accountName);
		account.setPassword(EncodeUtil.md5(password));
		
		//�洢
		AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
		accountMapper.create(account);
		sqlSession.commit();
		sqlSession.close();
		
		
		return "account.jsp";
	}

}
