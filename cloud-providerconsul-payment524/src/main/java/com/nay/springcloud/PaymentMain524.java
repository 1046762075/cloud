package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Title: PaymentMain524</p>
 * 作用：Consul
 * 		http://127.0.0.1:524/payment/consul/1
 * 时间：2020/4/9 18:40
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain524 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain524.class,args);
	}
}
