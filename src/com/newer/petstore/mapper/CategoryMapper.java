package com.newer.petstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.newer.petstore.domain.Category;

/**
 * ��Ʒ�������ݲ���
 * 
 * @author hwyou
 *
 */
public interface CategoryMapper {
	@Select("select * from Category order by title")
	List<Category> findAll();
}
