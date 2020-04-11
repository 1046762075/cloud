package com.nay.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>Title: OrderConsulController</p>
 * 作用：consul
 * 时间：2020/4/9 19:20
 */
@RestController
@Slf4j
public class OrderConsulController {

	public static final String INVOKE_URL = "http://cloud-providerconsul-payment";

	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/consumer/payment/consul")
	public String paymentInfo(){
		String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul",String.class);
		return 	"来自" + INVOKE_URL + "的信息：" + result;
	}
}
