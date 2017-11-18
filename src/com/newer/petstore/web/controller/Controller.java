package com.newer.petstore.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

/**
 * 控制器的执行(流程的规范）
 * 
 * @author hwyou
 *
 */
public interface Controller {
	
	//执行操作，三个参数
	String execute(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession) throws ServletException, IOException;
	
}
