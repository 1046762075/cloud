package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Title: OrderNacosMain84</p>
 * Description：84访问 603、604 进行负载均衡(三者同时注册Sentinel)
 * 			http://127.0.0.1:84/consumer/fallback/1
 *		fallback 管理Java异常
 *		http://127.0.0.1:84/consumer/fallback/4
 *		http://127.0.0.1:84/consumer/fallback/5
 *
 *	 ribbon VS openFeign [openFeign + Sentinel 实现服务降级]
 *		http://127.0.0.1:84/consumer/paymentSQL/1
 * date：2020/4/14 22:02
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderNacosMain84 {
	public static void main(String[] args) {
		SpringApplication.run(OrderNacosMain84.class,args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
