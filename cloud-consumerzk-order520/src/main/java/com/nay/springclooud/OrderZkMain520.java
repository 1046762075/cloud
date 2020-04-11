package com.nay.springclooud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Title: OrderZkMain520</p>
 * 作用：
 * 时间：2020/4/9 16:59
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderZkMain520 {
	public static void main(String[] args) {
		SpringApplication.run(OrderZkMain520.class,args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
