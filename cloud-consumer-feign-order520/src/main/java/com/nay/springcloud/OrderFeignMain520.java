package com.nay.springcloud;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * <p>Title: OrderFeignMain520</p>
 * 作用：http://127.0.0.1:520/feign/payment/get/1
 * 		 http://127.0.0.1:520/feign/payment/create?serial=lsl
 * 	！！！注意：Feign 默认是1秒内要收到回复 下面我们故意让他等待2秒 就会报 Read timed out
 *
 * 时间：2020/4/10 14:19
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class OrderFeignMain520 {

	public static void main(String[] args) {
		SpringApplication.run(OrderFeignMain520.class,args);
	}

	@Bean
	Logger.Level feignLoggerLevel(){
		/**
		 * NONE : 默认的，不显示任何日志;
		 * BASIC: 仅记录请求方法、URL、 响应状态码及执行时间; .
		 * HEADERS : 除了BASIC中定义的信息之外,还有请求和响应的头信息;
		 * FULL : 除了HEADERS中定义的信息之外,还有请求和响应的正文及元数据。
		 */
		return Logger.Level.FULL;
	}
}
