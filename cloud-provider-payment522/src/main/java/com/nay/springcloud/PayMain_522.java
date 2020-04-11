package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>Title: PayMain</p>
 * 作用：支付接口主启动类
 * 		http://127.0.0.1:522/payment/get/1
 * 		调用这个需要去掉create方法中的RequestBody
 * 		http://127.0.0.1:522/payment/create?serial=lsl
 * 		Feign延迟 在yml文件中配置
 * 		http://127.0.0.1:522/payment/feign/timeout
 * 时间：2020/4/8 13:35
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class PayMain_522 {
	public static void main(String[] args) {
		SpringApplication.run(PayMain_522.class,args);
	}
}