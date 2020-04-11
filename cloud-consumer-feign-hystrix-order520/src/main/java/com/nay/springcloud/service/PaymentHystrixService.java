package com.nay.springcloud.service;

import com.nay.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>Title: PaymentHystrixService</p>
 * 作用：Feign 实现服务降级
 * 时间：2020/4/10 20:39
 */
@Service
													// 接口的解耦
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

	@GetMapping(value = "/payment/hystrix/ok/{id}")
	String paymentInfo_OK(@PathVariable("id") Integer id);

	@GetMapping(value = "/payment/hystrix/timeout/{id}")
	String paymentInfo_Timeout(@PathVariable("id") Integer id);
}
