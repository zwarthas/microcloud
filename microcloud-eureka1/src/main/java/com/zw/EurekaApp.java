package com.zw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Import;

import com.zw.test.PersonConfig;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApp {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApp.class, args);
	}
}
