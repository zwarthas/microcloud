package com.zw.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/product")
	public Object getProduct(@PathVariable("id") int id) {
		return restTemplate.exchange(ProductConstants.PRODUCT_GET_URL, HttpMethod.GET,
				new HttpEntity<>(httpHeaders), Product.class);
	}

	@RequestMapping("/list")
	public Object listProduct() {
		List<Product> list = restTemplate
				.exchange(ProductConstants.PRODUCT_LIST_URL, HttpMethod.GET, new HttpEntity<>(httpHeaders), List.class)
				.getBody();
		return list;
	}
	
	@RequestMapping("/add")
	public Object addProduct(Product product) {
		Boolean result=restTemplate.exchange(ProductConstants.PRODUCT_ADD_URL, HttpMethod.POST,
				new HttpEntity<>(product,httpHeaders), Boolean.class).getBody();
		return result;
	}
	

}
