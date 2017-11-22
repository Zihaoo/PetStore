package com.newer.petstore.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.newer.petstore.AppInfo;
import com.newer.petstore.domain.Cart;
import com.newer.petstore.domain.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ÿ�Ρ����빺�ﳵ������ http get ����Я��һ����ѯ���� id
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HTTP �Ĳ������ı���ʽ(�ַ�����
		String idValue = request.getParameter("id");
		int id = Integer.parseInt(idValue);

		List<Product> list = (List<Product>) getServletContext().getAttribute(AppInfo.APP_PRPDUCT_LIST);
		// System.out.println(list);
		Product product = null;
		for (Product p : list) {
			if (p.getId() == id) {
				product = p;
			}
		}

		// ���빺�ﳵ
		Cart cart = (Cart) request.getSession().getAttribute(AppInfo.SESSION_CART);
		cart.addCart(product);

		// ��Ӧ�ض���
		// response.sendRedirect("cart.jsp");
		// response.getWriter().write("");
		
		//������
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("result", "�ѷ��빺�ﳵ");
		map.put("resultcode", 1);
		String json = new Gson().toJson(map);
		
		//
		response.getWriter().write(json);
	}

}
