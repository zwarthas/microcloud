package com.zw.mapper;

import java.util.List;

import com.zw.vo.Product;

public interface ProductMapper {
	boolean create(Product product);

	public Product findById(Long id);

	public List<Product> findAll();
}
