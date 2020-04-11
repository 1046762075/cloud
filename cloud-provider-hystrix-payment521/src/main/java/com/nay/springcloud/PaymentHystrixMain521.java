package com.nay.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * <p>Title: PaymentHystrixMain521</p>
 * 作用：服务降级熔断
 * 			http://127.0.0.1:521/payment/hystrix/ok/1
 * 			http://127.0.0.1:521/payment/hystrix/timeout/1
 * 			狂点10次 如果60%都是无效的访问 那么就会触发熔断 然后慢慢恢复(这个是可以配置的)
 * 			http://127.0.0.1:521/payment/hystrix/circuit/1
 * 			http://127.0.0.1:521/payment/hystrix/circuit/-1
 *
 * 		所有参数在：HystrixCommandProperties
 * 时间：2020/4/10 18:03
 */
// 开启熔断器
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class PaymentHystrixMain521 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentHystrixMain521.class,args);
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
