package com.zw.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zw.service.IProductService;
import com.zw.vo.Product;

@Component
public class TestBean {

	@Resource
	IProductService productService;
	
	@HystrixCommand(fallbackMethod = "getDefault")
    public Product get(@PathVariable("id") long id) {
		Product product=this.productService.get(id) ;
		if(product==null)throw new RuntimeException();
        return product;
    }
	
	public Product getDefault(@PathVariable("id") long id) {
		Product product = new Product();
        product.setProductName("HystrixName");
        product.setProductDesc("HystrixDesc");
        product.setProductId(0L);
        return product;
	}
	
}
