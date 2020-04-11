package com.nay.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: PaymentService</p>
 * 作用：服务降级熔断
 * 时间：2020/4/10 18:05
 */
@Service
public class PaymentService {

	@Value("${time}")
	private Integer outTime;

	public String paymentInfo_OK(Integer id){
		Instant now = Instant.now();
		return "线程池：" + Thread.currentThread().getName() + "paymentInfo_OK：" + id + "\t ^_^" + "耗时：" + Duration.between(now,Instant.now()).toMillis() + "毫秒";
	}

	/**
	 * 如果 paymentInfo_Timeout 崩了 就去找 paymentInfo_TimeoutHandler 方法
	 */
	@HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler" ,commandProperties = {
																// 这个线程的超时时间是3秒 就是说 超过3秒就会调用 paymentInfo_TimeoutHandler
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1003")
	})
	public String paymentInfo_Timeout(Integer id){
		Instant now = Instant.now();
		try {
			TimeUnit.SECONDS.sleep(outTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "线程池：" + Thread.currentThread().getName() + "paymentInfo_Timeout：" + id + "\t 耗时：" + Duration.between(now,Instant.now()).toMillis() + "毫秒";
	}

	public String paymentInfo_TimeoutHandler(Integer id){
		Instant now = Instant.now();
		return "服务器跑丢了^_^请稍后再来~~~" + "paymentInfo_TimeoutHandler：" + id + "\t 耗时：" + (1000+Duration.between(now,Instant.now()).toMillis()) + "毫秒";
	}

	/**
	 * 服务熔断
	 * 所有参数在：HystrixCommandProperties
	 */
	@HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开启断路器
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") // 失败率达到多少后跳闸
	})
	public String paymentCircuitBreaker(Integer id){
		if(id < 0){
			throw new RuntimeException("id 不能为负数");
		}
		return Thread.currentThread().getName() + "\t 条用成功，流水号：" + IdUtil.simpleUUID();
	}

	public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
		return "id 不能为负数，请稍后再试(O_O)";
	}
}
