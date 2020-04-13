package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Title: PaymentMain999</p>
 * 作用：Linux上搭建 Nacos 集群
 * 			http://127.0.0.1:999/payment/nacos/1
 * 时间：2020/4/13 21:41
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain999 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain999.class,args);
	}
}
