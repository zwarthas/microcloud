package com.zw.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zw.vo.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/get/{name}")
	@HystrixCommand(fallbackMethod = "fallback")
	public User getUser(@PathVariable("name") String name) {
		User users = new User();
		users.setName(name);
		users.setAge(18);
		users.setSex("F");
		return users;
	}

	public User fallback(@PathVariable("name") String name) {
		User users = new User();
		users.setName("noName");
		users.setAge(18);
		users.setSex("F");
		return users;
	}
	
}
