package com.nay.springcloud.controller;

import com.nay.springcloud.entities.CommonResult;
import com.nay.springcloud.entities.Payment;
import com.nay.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>Title: OrderFeignController</p>
 * 作用：通过 Feign 调用服务
 * 时间：2020/4/10 14:40
 */
@RestController
@Slf4j
@RequestMapping("/feign/payment")
public class OrderFeignController {

	@Resource
	private PaymentFeignService paymentFeignService;

	@GetMapping(value = "/timeout")
	public String paymentFeignTimeout(){
		return paymentFeignService.paymentFeignTimeout();
	}

	@PostMapping(value = "/create")
	public CommonResult create(Payment payment){
		return paymentFeignService.create(payment);
	}

	@GetMapping("/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id){
		return paymentFeignService.getPaymentById(id);
	}
}
