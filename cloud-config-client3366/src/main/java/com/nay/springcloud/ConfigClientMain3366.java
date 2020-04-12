package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>Title: ConfigClientMain3366</p>
 * 作用：
 * 			http://config-3344.com:3366/configInfo
 * 时间：2020/4/12 17:06
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3366 {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientMain3366.class,args);
	}
}
