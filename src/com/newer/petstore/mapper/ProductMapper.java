package com.newer.petstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.newer.petstore.domain.Product;

public interface ProductMapper {
	
	@Select("select id,title,price,quantity,salesNum,concat('.',pic) picPath from Product order by title")
	List<Product> findAll();
	
	@Select("select id,title,price,quantity,salesNum,concat('.',pic) picPath from Product where title like concat('%',#{keywords},'%') or info like concat('%',#{keywords},'%')")
	List<Product> search(String keywords);
}
