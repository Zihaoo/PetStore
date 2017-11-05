package com.newer.petstore.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.newer.petstore.AppInfo;
import com.newer.petstore.domain.Product;
import com.newer.petstore.mapper.ProductMapper;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
@WebListener
public class InitListener implements ServletContextListener {
	/**
	 * �Ự����
	 */
	SqlSessionFactory factory;
	
    /**
     * 
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * �����ʼ��
     */
    public void contextInitialized(ServletContextEvent e)  {
    	//�������Դ��mybatis -sqlSessionFactory��
    	factory = getFactory();
    	ServletContext application = e.getServletContext();
    	application.setAttribute(AppInfo.APP_SESSION_FACTORY, factory);
    	
    	//����ȫ�ֵ�����
    	loadData(application);
    }

	private void loadData(ServletContext application) {
		SqlSession sqlSession = factory.openSession();
		
		//����ṩ�˾����ʵ��(��̬����
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		List<Product> list = mapper.findAll();
		
		application.setAttribute(AppInfo.APP_PRPDUCT_LIST, list);
		System.out.println(list);
		
		sqlSession.commit();
		sqlSession.close();
	}

	private SqlSessionFactory getFactory() {
		try {
			InputStream in = Resources.getResourceAsStream("config.xml");
			//ʹ��in�����Ự����
			return new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
