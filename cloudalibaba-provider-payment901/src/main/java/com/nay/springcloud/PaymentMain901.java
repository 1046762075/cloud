package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Title: PaymentMain901</p>
 * 作用：Nacos
 * 			http://127.0.0.1:901/payment/nacos/1
 * 时间：2020/4/13 13:23
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain901 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain901.class,args);
	}
}
