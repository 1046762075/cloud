package com.nay.springcloud;

import com.nay.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * <p>Title: OrderMain</p>
 * 			http://127.0.0.1:520/consumer/payment/getForEntity/1
 * 			http://127.0.0.1:520/consumer/payment/get/1
 自定义轮询 http://127.0.0.1:520/consumer/payment/lb/1
 * 时间：2020/4/8 16:34
 */
// 开启自定义 Ribbon 并指定配置文件的位置
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
@EnableEurekaClient
@SpringBootApplication
public class OrderMain {
	public static void main(String[] args) {
		SpringApplication.run(OrderMain.class,args);
	}
}
