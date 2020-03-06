package com.zw.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignClientConfig {

	@Bean
	public Logger.Level getFeignLogger(){
		return Logger.Level.FULL;
	}
	
	@Bean
	public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("admin", "123456");
	}
	
	
}
