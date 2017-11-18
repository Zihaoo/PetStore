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
 * �����˲�������
 * 
 * @author hwyou
 *
 */
public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accountName = request.getParameter("account");
		//����
		String password = request.getParameter("password");

		AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
		Account account = mapper.login(accountName);
		if (account != null && account.getPassword().equals(EncodeUtil.md5(password))) {
			// �û�������ƥ��
			request.getSession().setAttribute("account", account);
			return "cart.jsp";
		} else {
			// ��ƥ��
			request.getSession().setAttribute("errorMessage", "�û��������벻ƥ��");
			return "account.jsp";
		}

	}

}
