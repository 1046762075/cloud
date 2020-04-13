package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Title: PaymentMain911</p>
 * 作用：Nacos
 * 				http://127.0.0.1:911/payment/nacos/1
 * 时间：2020/4/13 13:33
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain911 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain911.class,args);
	}
}
