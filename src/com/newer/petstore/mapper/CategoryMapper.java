package com.newer.petstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.newer.petstore.domain.Category;
import com.newer.petstore.domain.Product;

/**
 * 产品分类数据操作
 * 
 * @author hwyou
 *
 */
public interface CategoryMapper {
	@Select("select * from Category order by title")
	List<Category> findAll();

	/**
	 * 获得特定分类的商品列表
	 * 
	 * @param title
	 *            分类的名称
	 * @return List<Product> 该分类中的所有商品
	 */
	@Select("select p.id,p.title,price,info,quantity,salesNum,pic,c.title\r\n"
			+ "from product p,category c where p.category_id=c.id;")
	List<Product> getProductsByCategory(String title);
}
