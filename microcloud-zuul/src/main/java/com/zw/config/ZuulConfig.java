package com.zw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zw.filter.AuthorizedRequestFilter;

@Configuration
public class ZuulConfig {

	@Bean
	public AuthorizedRequestFilter authorizedRequestFilter() {
		return new AuthorizedRequestFilter();
	}
	
}
