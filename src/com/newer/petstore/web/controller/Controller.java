package com.newer.petstore.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

/**
 * ��������ִ��(���̵Ĺ淶��
 * 
 * @author hwyou
 *
 */
public interface Controller {
	
	//ִ�в�������������
	String execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession) throws ServletException, IOException;
	
}
