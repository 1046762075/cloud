package com.nay.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>Title: OrderNacosController</p>
 * 作用：
 * 时间：2020/4/13 14:39
 */
@RestController
@Slf4j
public class OrderNacosController {

//	public static final String SERVER_URL = "http://alibaba-provider-payment";

	@Resource
	private RestTemplate restTemplate;

	@Value("${service-url.nacos-user-service}")
	private String serverURL;

	@GetMapping("/consumer/payment/nacos/{id}")
	public String paymentInfo(@PathVariable("id") Integer id){
		return restTemplate.getForObject(serverURL + "/payment/nacos/" + id,String.class);
	}
}
