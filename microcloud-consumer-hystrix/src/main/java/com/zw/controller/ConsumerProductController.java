package com.zw.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zw.service.IFeignProductService;
import com.zw.vo.Product;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {

	@Resource
	IFeignProductService productService;

	@RequestMapping("/product/get/{id}")
	public Object getProduct(@PathVariable("id") long id) {
		return productService.getProduct(id);
	}

	@RequestMapping("/product/list")
	public Object listProduct() {
		return productService.listProducts();
	}
	
	@RequestMapping("/product/add")
	public Object addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	

}
