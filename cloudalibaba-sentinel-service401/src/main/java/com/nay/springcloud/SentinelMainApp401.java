package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Title: SentinelMainApp401</p>
 * 作用：Sentinel 监控
 * 			http://127.0.0.1:401/testA
 * 			http://127.0.0.1:401/testB
 * 时间：2020/4/13 22:46
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMainApp401 {
	public static void main(String[] args) {
		SpringApplication.run(SentinelMainApp401.class,args);
	}
}
