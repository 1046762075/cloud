package com.nay.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Title: ApplicationContextConfig</p>
 * 作用：
 * 时间：2020/4/8 16:47
 */
@Configuration
public class ApplicationContextConfig {

	@Bean
//	负载均衡机制 赋予了 RestTemplate 负载均衡的能力
//	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
