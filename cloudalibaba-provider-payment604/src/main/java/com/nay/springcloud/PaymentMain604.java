package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Title: PaymentMain604</p>
 * Description：
 * 				http://127.0.0.1:604/paymentSQL/1
 * date：2020/4/14 21:42
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain604 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain604.class,args);
	}
}
