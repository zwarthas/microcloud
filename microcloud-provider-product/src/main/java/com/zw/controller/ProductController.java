package com.zw.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zw.service.IProductService;
import com.zw.vo.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Resource
	IProductService productService;
	
	@RequestMapping(value="/get/{id}")
    public Object get(@PathVariable("id") long id) {
        return this.productService.get(id) ;
    }
	
    @RequestMapping(value="/add")
    public Object add(@RequestBody Product product) {
        return this.productService.add(product) ;
    }
    
    @RequestMapping(value="/list")
    public Object list() {
        return this.productService.list() ;
    }
	
}
