package com.zw.service;

import org.springframework.stereotype.Component;

import com.zw.vo.Product;
import com.zw.vo.User;

import feign.hystrix.FallbackFactory;

@Component
public class IZuulClientServiceFallbackFactory implements FallbackFactory<IZuulClientService>{

	@Override
	public IZuulClientService create(Throwable cause) {
		return new IZuulClientService() {
			
			@Override
			public User getUser(String userName) {
				User user = new User();
		        user.setSex("F");
		        user.setAge(17);
		        user.setName("zuul-fllback："+userName);
		        return user;

			}

			@Override
			public Product getProduct(int id) {
				Product product = new Product();
		        product.setProductId(999999L);
		        product.setProductName("feign-zuulName");
		        product.setProductDesc("feign-zuulDesc");
		        return  product;

			}
		};
	}

	

	
	
}
