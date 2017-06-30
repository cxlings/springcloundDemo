package com.example.demo.eurka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurkaApplication {

	/**
	 * 服务的注册中心 启动
	 * @param args
   */
	public static void main(String[] args) {
		SpringApplication.run(EurkaApplication.class, args);
	}
}
