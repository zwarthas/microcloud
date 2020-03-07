package com.zw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class UserApp {

	public static void main(String[] args) {
		SpringApplication.run(UserApp.class, args);
	}
}
