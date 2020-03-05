package com.zw.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zw.mapper.ProductMapper;
import com.zw.service.IProductService;
import com.zw.vo.Product;

@Service
public class ProductServiceImp implements IProductService {

	@Resource
	ProductMapper productMapper;

	@Override
	public Product get(long id) {
		return productMapper.findById(id);
	}

	@Override
	public boolean add(Product product) {
		return productMapper.create(product);
	}

	@Override
	public List<Product> list() {
		return productMapper.findAll();
	}

}
