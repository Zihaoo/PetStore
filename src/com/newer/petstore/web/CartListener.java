package com.newer.petstore.web;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.newer.petstore.AppInfo;
import com.newer.petstore.domain.Cart;

/**
 * ������ֻ��һ��
 * Application Lifecycle Listener implementation class CartListener
 *
 */
@WebListener
public class CartListener implements HttpSessionListener {

	int counter;

	/**
     * �����µĶԻ������úܶ�Σ�
     */
    public void sessionCreated(HttpSessionEvent e)  { 
    	counter++;
    	System.out.println("�����Ự"+e.getSession().getId());
    	
    	//�洢��������
    	e.getSession().getServletContext().setAttribute("online", counter);
    	
    	//��ÿһ���Ự����һ�����ﳵ
    	Cart cart = new Cart();
    	e.getSession().setAttribute(AppInfo.SESSION_CART, cart);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent e)  { 
    	counter--;
    	System.out.println("�Ự����"+e.getSession().getId());
    	ServletContext application = e.getSession().getServletContext();
    	application.setAttribute("online", counter);
    	
    }
	
}
