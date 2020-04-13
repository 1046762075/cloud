package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Title: OrderNacosMain523</p>
 * 作用：
 * 时间：2020/4/13 14:31
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderNacosMain523 {
	public static void main(String[] args) {
		SpringApplication.run(OrderNacosMain523.class,args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
