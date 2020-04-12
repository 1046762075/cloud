package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>Title: StreamMQMain802</p>
 * 作用：此处可以不加 @EnableEurekaClient
 * 			这个只是用来接收消息
 * 时间：2020/4/12 21:51
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamReceiveMQMain802 {
	public static void main(String[] args) {
		SpringApplication.run(StreamReceiveMQMain802.class,args);
	}
}
