package com.nay.springcloud.service;

import com.nay.springcloud.entities.CommonResult;
import com.nay.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>Title: PaymentFeignService</p>
 * 作用：Feign 来做中间调用
 * 		！！！注意：这里的Get、Post路径要跟目标的一致
 * 时间：2020/4/10 14:33
 */
// 这里写的就是 Eureka 中的服务名称
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentFeignService {

	@GetMapping(value = "/payment/feign/timeout")
	String paymentFeignTimeout();

	@PostMapping(value = "/payment/create")
	CommonResult create(@RequestBody Payment payment);

	@GetMapping(value = "/payment/get/{id}")
	CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id);
}
