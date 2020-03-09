package com.zw.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zw.feign.FeignClientConfig;
import com.zw.vo.Product;
import com.zw.vo.User;

@FeignClient(name="MICROCLOUD-ZUUL-APPLICATION",configuration = FeignClientConfig.class,
fallbackFactory = IZuulClientServiceFallbackFactory.class)
public interface IZuulClientService {

	@RequestMapping("/api/proxy-user/user/get/{name}")
	public User getUser(@PathVariable("name")String userName) ;
	
	@RequestMapping("/api/proxy-product/product/get/{id}")
	public Product getProduct(@PathVariable("id") int id);
	
}
