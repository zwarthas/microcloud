package com.zw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashbordApp {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashbordApp.class, args);
	}
}
