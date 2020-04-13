package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Title: NacosConfigMain3377</p>
 * 作用：
 * 时间：2020/4/13 15:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigMain3377 {
	public static void main(String[] args) {
		SpringApplication.run(NacosConfigMain3377.class,args);
	}
}
