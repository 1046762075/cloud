package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>Title: ConfigClientMain3355</p>
 * 作用：
 * 			http://config-3344.com:3355/configInfo
 * 时间：2020/4/12 15:44
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3355 {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientMain3355.class,args);
	}
}
