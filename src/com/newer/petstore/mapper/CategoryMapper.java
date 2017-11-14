package com.newer.petstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.newer.petstore.domain.Category;
import com.newer.petstore.domain.Product;

/**
 * ��Ʒ�������ݲ���
 * 
 * @author hwyou
 *
 */
public interface CategoryMapper {
	@Select("select * from Category order by title")
	List<Category> findAll();

	/**
	 * ����ض��������Ʒ�б�
	 * 
	 * @param title
	 *            ���������
	 * @return List<Product> �÷����е�������Ʒ
	 */
	@Select("select p.id,p.title,price,info,quantity,salesNum,pic,c.title from product p,category c where p.category_id=c.id")
	List<Product> getProductsByCategory(String title);
}
