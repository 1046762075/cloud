package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Title: OrderConsulMain520</p>
 * 作用：
 * 时间：2020/4/9 19:14
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderConsulMain520 {
	public static void main(String[] args) {
		SpringApplication.run(OrderConsulMain520.class,args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
