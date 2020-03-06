package com.zw.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class PersonConfig {

	@Bean
	public Person person() {
		return new Person();
	}
}
