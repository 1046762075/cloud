package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>Title: OrderMain201</p>
 * Description：
 * 		http://127.0.0.1:201/order/create?id=1&userId=1&productId=1&count=10&money=100
 * date：2020/4/15 14:17
 */
@EnableFeignClients
@EnableDiscoveryClient
/**
 * 取消数据源的自带创建
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OrderMain201 {

	public static void main(String[] args) {
		SpringApplication.run(OrderMain201.class,args);
	}
}
