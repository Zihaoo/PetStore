package com.newer.petstore.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��������ִ��(���̵Ĺ淶��
 * 
 * @author hwyou
 *
 */
public interface Controller {

	String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
