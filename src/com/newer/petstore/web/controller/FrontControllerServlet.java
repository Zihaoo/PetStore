package com.newer.petstore.web.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ǰ�˿�����  ���������е�����
 * @author hwyou
 *
 */
public class FrontControllerServlet extends HttpServlet {
	//���������ļ���д��
    HashMap<String,Class> map = new HashMap<>();
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	//����URL��Controller��ӳ��(Ҳ����ʹ��ע��)
    	map.put("/register.action", RegisterController.class);
    	map.put("/login.action", LoginController.class);
    	
    	
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String url = request.getRequestURI();
		String urlName = url.substring(url.lastIndexOf("/"));
		
		//��ӳ���л��url���ڵĿ�������
		Class controllerClass = map.get(urlName);
		if(controllerClass != null) { 
			//ʹ�÷��䴴�����͵�ʵ��
			Controller controller;
			try {
				controller = (Controller)controllerClass.newInstance();
				//����ִ��
				String page = controller.execute(request, response);
				//��Ӧ���ض���
				response.sendRedirect(page);
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("error/404.html");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
