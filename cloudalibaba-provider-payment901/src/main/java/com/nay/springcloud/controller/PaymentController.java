package com.nay.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: PaymentController</p>
 * 作用：
 * 时间：2020/4/13 13:24
 */
@RestController
@Slf4j
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/payment/nacos/{id}")
	public String getPayment(@PathVariable("id") Integer id){
		log.info("访问 Nacos 成功,访问ID: " + id);
		return "访问 Nacos 成功 nacos registry, serverPort：" + serverPort + "\t id: " + id;
	}
}
