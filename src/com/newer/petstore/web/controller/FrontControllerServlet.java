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
 * 前端控制器  （拦截所有的请求）
 * @author hwyou
 *
 */
public class FrontControllerServlet extends HttpServlet {
	//不用配置文件的写法
    HashMap<String,Class> map = new HashMap<>();
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	//设置URL和Controller的映射(也可以使用注解)
    	map.put("/register.action", RegisterController.class);
    	map.put("/login.action", LoginController.class);
    	
    	
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String url = request.getRequestURI();
		String urlName = url.substring(url.lastIndexOf("/"));
		
		//从映射中获得url对于的控制器类
		Class controllerClass = map.get(urlName);
		if(controllerClass != null) { 
			//使用反射创建类型的实例
			Controller controller;
			try {
				controller = (Controller)controllerClass.newInstance();
				//调用执行
				String page = controller.execute(request, response);
				//响应的重定向
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
