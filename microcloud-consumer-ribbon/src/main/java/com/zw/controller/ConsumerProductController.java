package com.zw.controller;

import java.net.URI;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zw.constants.ProductConstants;
import com.zw.vo.Product;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {

	@Resource
	private HttpHeaders httpHeaders;

	@Resource
	private RestTemplate restTemplate;
	
	@Resource
	LoadBalancerClient loadBalancerClient;

	@RequestMapping("/product/get/{id}")
	public Object getProduct(@PathVariable("id") long id) {
		Product p= restTemplate.exchange(ProductConstants.PRODUCT_GET_URL+id, HttpMethod.GET,
				new HttpEntity<>(httpHeaders), Product.class).getBody();
		return p;
	}

	@RequestMapping("/product/list")
	public Object listProduct() {
		ServiceInstance serviceInstance=loadBalancerClient.choose("MICROCLOUD-PROVIDER-PRODUCT");
		URI uri = URI.create(String.format("http://%s:%s/product/list/" ,
                serviceInstance.getHost(), serviceInstance.getPort()));
		@SuppressWarnings("unchecked")
		List<Product> list = restTemplate
				.exchange(uri, HttpMethod.GET, new HttpEntity<>(httpHeaders), List.class)
				.getBody();
		return list;
	}
	
	@RequestMapping("/product/add")
	public Object addProduct(@RequestBody Product product) {
		Boolean result=restTemplate.exchange(ProductConstants.PRODUCT_ADD_URL, HttpMethod.POST,
				new HttpEntity<>(product,httpHeaders), Boolean.class).getBody();
		return result;
	}
	
	

}
