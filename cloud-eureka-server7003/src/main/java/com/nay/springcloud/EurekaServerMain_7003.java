package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerMain_7003 {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerMain_7003.class, args);
	}

}
