package com.nay.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * <p>Title: OrderHystrixMain520</p>
 * 作用：Hystrix 实现服务远程调用
 * 		http://127.0.0.1:520/orderHystrix/ok/1
 * 		http://127.0.0.1:520/orderHystrix/timeout/1
 * 		服务降级：
 * 		http://127.0.0.1:520/orderHystrix/feign/1
 * 时间：2020/4/10 20:37
 */
// 远程服务调用
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
public class OrderHystrixMain520 {
	public static void main(String[] args) {
		SpringApplication.run(OrderHystrixMain520.class,args);
	}

	/**
	 * 注册 Hystrix 监控
	 */
	@Bean
	public ServletRegistrationBean getServlet(){
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}
}
