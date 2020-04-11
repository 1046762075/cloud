package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * <p>Title: HystrixDashboardMain621</p>
 * 作用：监控 520 521
 * 		http://127.0.0.1:621/hystrix
 *
 * 		输入:http://localhost:520/hystrix.stream  或者 http://localhost:521/hystrix.stream
 * 时间：2020/4/11 14:49
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardMain621 {
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardMain621.class,args);
	}
}
