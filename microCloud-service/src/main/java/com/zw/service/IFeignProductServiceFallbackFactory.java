package com.zw.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zw.vo.Product;

import feign.hystrix.FallbackFactory;

@Component
public class IFeignProductServiceFallbackFactory implements FallbackFactory<IFeignProductService>{

	@Override
	public IFeignProductService create(Throwable cause) {
		return new IFeignProductService() {
			
			@Override
			public List<Product> listProducts() {
				return null;
			}
			
			@Override
			public Product getProduct(long id) {
				Product product = new Product();
                product.setProductId(999999L);
                product.setProductName("feign-hystrixName");
                product.setProductDesc("feign-hystrixDesc");
                return  product;
			}
			
			@Override
			public boolean addProduct(Product product) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

	
	
	
}
