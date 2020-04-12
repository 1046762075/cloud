package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>Title: StreamMQMain801</p>
 * 作用：此处可以不加 @EnableEurekaClient
 * 				http://127.0.0.1:801/sendMessage
 *
 * 		总结：只能被消息一次的消息放在同一个组 不同的组都会共享同一条消息
 * 时间：2020/4/12 21:05
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamSendMQMain801 {
	public static void main(String[] args) {
		SpringApplication.run(StreamSendMQMain801.class,args);
	}
}
