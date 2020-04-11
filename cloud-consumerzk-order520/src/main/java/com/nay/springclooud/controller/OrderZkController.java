package com.nay.springclooud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>Title: OrderZkController</p>
 * 作用：Zk 注册调用
 * 时间：2020/4/9 17:04
 */
@Controller
@Slf4j
public class OrderZkController {

	public static final String INVOKE_URL = "http://cloud-provider-payment";

	@Resource
	private RestTemplate restTemplate;

	@ResponseBody
	@GetMapping("/consumer/payment/zk")
	public String paymentInfo(){
		String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk",String.class);
		return 	"来自" + INVOKE_URL + "的信息：" + result;
	}
}
