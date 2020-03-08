package com.zw.controller;

import javax.annotation.Resource;
import com.zw.vo.*;
import java.util.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zw.service.IZuulClientService;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {

	@Resource
	 IZuulClientService clientService;

	@RequestMapping("/product/user/{id}/{name}")
	public Object getUserAndProduct(@PathVariable("id") int id,@PathVariable("name")String name) {
		Product product = clientService.getProduct(id);
		User user = clientService.getUser(name);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("user",user);
		result.put("product", product);
		return result;
	}
	
	

}
