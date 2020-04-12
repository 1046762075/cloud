package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>Title: MainAppConfig3344</p>
 * 作用：
 * 时间：2020/4/12 13:00
 */
@EnableEurekaClient
@SpringBootApplication
public class MainAppConfig3344 {
	public static void main(String[] args) {
		SpringApplication.run(MainAppConfig3344.class,args);
	}
}
