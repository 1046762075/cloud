package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Title: PaymentMain603</p>
 * Description：
 *
 * date：2020/4/14 21:46
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain603 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain603.class,args);
	}
}
