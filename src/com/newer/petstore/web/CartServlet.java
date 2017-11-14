package com.newer.petstore.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.petstore.AppInfo;
import com.newer.petstore.domain.Cart;
import com.newer.petstore.domain.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	//每次【加入购物车】操作 http get 请求，携带一个查询参数 id
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTTP 的参数是文本格式(字符串）
		String idValue = request.getParameter("id");
		int id = Integer.parseInt(idValue);
		
		
		List<Product> list = (List<Product>) getServletContext().getAttribute(AppInfo.APP_PRPDUCT_LIST);
		//System.out.println(list);
		Product product = null;
		for(Product p : list) {
			if(p.getId() == id) {
				product = p;
			}
		}
		
		//加入购物车
		Cart cart = (Cart) request.getSession().getAttribute(AppInfo.SESSION_CART);
		System.out.println(product);
		cart.addCart(product);
		//响应重定向
		response.sendRedirect("cart.jsp");
	}



}
