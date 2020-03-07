package com.zw.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersonImportBean.class)
public class PersonConfig {

//	@Bean
//	public Person person() {
//		return new Person();
//	}
}
