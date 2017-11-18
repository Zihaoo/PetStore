package com.newer.petstore.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.newer.petstore.AppInfo;
import com.newer.petstore.mapper.AccountMapper;

public class CheckAccountController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession)
			throws ServletException, IOException {
		
		String account = request.getParameter("account");
		//spring

		AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
		String password = mapper.checkName(account);
		
		return "ajax:" + (password == null ? "可用" : "已占有");
		
	}

}
