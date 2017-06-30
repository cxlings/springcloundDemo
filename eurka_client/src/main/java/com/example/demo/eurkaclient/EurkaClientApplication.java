package com.example.demo.eurkaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurkaClientApplication {

	/**
	 * 服务提供者 在 注册中心注册
	 * @param args
   */
	public static void main(String[] args) {
		SpringApplication.run(EurkaClientApplication.class, args);
	}
}
