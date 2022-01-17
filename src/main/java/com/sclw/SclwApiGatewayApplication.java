package com.sclw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SclwApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SclwApiGatewayApplication.class, args);
	}

}
