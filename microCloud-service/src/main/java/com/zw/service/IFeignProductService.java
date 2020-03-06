package com.zw.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zw.feign.FeignClientConfig;
import com.zw.vo.Product;

@FeignClient(name = "MICROCLOUD-PROVIDER-PRODUCT",configuration = FeignClientConfig.class)
public interface IFeignProductService {

	@RequestMapping(value="/product/get/{id}")
    public Product getProduct(@PathVariable("id") long id) ;
	
    @RequestMapping(value="/product/add")
    public boolean addProduct(@RequestBody Product product) ;
    
    @RequestMapping(value="/product/list")
    public List<Product> listProducts() ;

}
