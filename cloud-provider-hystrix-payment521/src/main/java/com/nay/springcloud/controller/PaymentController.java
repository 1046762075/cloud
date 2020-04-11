package com.nay.springcloud.controller;

import com.nay.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>Title: PaymentController</p>
 * 作用：
 * 时间：2020/4/10 18:23
 */
@RestController
@Slf4j
@RequestMapping("/payment/hystrix")
public class PaymentController {

	@Resource
	private PaymentService paymentService;

	@GetMapping(value = "/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") Integer id){
		String result = paymentService.paymentInfo_OK(id);
		log.info("*****result:" +result);
		return result;
	}
	@GetMapping(value = "/timeout/{id}")
	public String paymentInfo_Timeout(@PathVariable("id") Integer id){
		String result = paymentService.paymentInfo_Timeout(id);
		log.info("*****result:" +result);
		return result;
	}

	@GetMapping(value = "/circuit/{id}")
	public String paymentCircuitBreaker(@PathVariable("id") Integer id){
		String result = paymentService.paymentCircuitBreaker(id);
		log.info("*****result:" +result);
		return result;
	}
}
