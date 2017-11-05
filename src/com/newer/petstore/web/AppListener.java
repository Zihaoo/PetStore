package com.newer.petstore.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.newer.petstore.AppInfo;
import com.newer.petstore.domain.Category;
import com.newer.petstore.mapper.CategoryMapper;

/**
 * ���������ض��¼�����ʱ����Ӧ�ó���������ģ�
 * 
 * @author 
 *
 */
//@WebListener
public class AppListener implements ServletContextListener {

	private SqlSessionFactory factory;

	
	/**
	 * Ӧ�ó���ĳ�ʼ��(�����ع�)
	 */
	public void contextInitialized(ServletContextEvent e) {
		// Java Web ���������
		ServletContext application = e.getServletContext();

		factory = initSqlSessionFactory(application);
		application.setAttribute(AppInfo.APP_SESSION_FACTORY, factory);

		loadCategoryList(application);

		loadProductList(application);
	}

	private void loadProductList(ServletContext application) {

	}

	/**
	 * �����Ự����: ��������Դ��myBatis �еĻỰ��������һ������Դ��
	 * 
	 * @param application
	 */
	private SqlSessionFactory initSqlSessionFactory(ServletContext application) {
		InputStream in;
		try {
			in = Resources.getResourceAsStream("config.xml");
			return new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e1) {
			return null;
		}
	}

	/**
	 * ���ز�Ʒ�����б�
	 * 
	 * @param application
	 * @param factory
	 */
	private void loadCategoryList(ServletContext application) {
		SqlSession sqlSession = factory.openSession();
		// �Ựִ�����ݲ���
		CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
		// �����ݿ��ѯ���ȫ�ֵ�������Ϣ
		List<Category> c = categoryMapper.findAll();
		// �洢��ȫ��������
		application.setAttribute(AppInfo.APP_CATEGORY_LIST, c);
		System.out.println("Ӧ�������ĳ�ʼ����ϣ�" + c);

		sqlSession.commit();
		sqlSession.close();
	}

	/**
	 * ���٣������Ƴ������������ã��ص� callback��
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO

	}

}