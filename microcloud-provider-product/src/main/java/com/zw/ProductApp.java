package com.zw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@MapperScan("com.zw.mapper")
public class ProductApp {

	public static void main(String[] args) {
		SpringApplication.run(ProductApp.class, args);
	}
	
}
