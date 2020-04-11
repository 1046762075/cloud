package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Title: PayMain</p>
 * 作用：EnableDiscoveryClient ：以后跟服务打交道基本上就是用这个 Zk
 * 		http://127.0.0.1:523/payment/zk/1
 * 时间：2020/4/8 13:35
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PayMainZk_523 {
	public static void main(String[] args) {
		SpringApplication.run(PayMainZk_523.class,args);
	}
}