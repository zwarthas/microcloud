package com.zw.controller;

import javax.annotation.Resource;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zw.service.IProductService;
import com.zw.vo.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Resource
	IProductService productService;
	
	@Resource
	DiscoveryClient discoveryClient;
	
	@RequestMapping(value="/get/{id}")
	@HystrixCommand(fallbackMethod = "getDefault")
    public Object get(@PathVariable("id") long id) {
		Product product=this.productService.get(id) ;
		if(product==null)throw new RuntimeException();
        return product;
    }
	
	public Product getDefault(/* @PathVariable("id") */ long id) {
		Product product = new Product();
        product.setProductName("HystrixName");
        product.setProductDesc("HystrixDesc");
        product.setProductId(0L);
        return product;

	}
	
    @RequestMapping(value="/add")
    public Object add(@RequestBody Product product) {
        return this.productService.add(product) ;
    }
    
    @RequestMapping(value="/list")
    public Object list() {
        return this.productService.list() ;
    }
    
    @RequestMapping("/discovery")
    public Object discovery() {
    	return discoveryClient;
    }
	
}
