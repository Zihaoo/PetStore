package com.newer.petstore.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义了操作方法
 * 
 * @author hwyou
 *
 */
public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		
		System.out.println("login");
		return "l.html";
	}

}
