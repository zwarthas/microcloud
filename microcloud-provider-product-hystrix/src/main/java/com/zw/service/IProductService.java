package com.zw.service;

import java.util.List;

import com.zw.vo.Product;

public interface IProductService {
	Product get(long id);

	boolean add(Product product);

	List<Product> list();
}
