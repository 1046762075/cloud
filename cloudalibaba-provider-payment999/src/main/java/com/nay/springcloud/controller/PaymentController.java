package com.nay.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: PaymentController</p>
 * 作用：
 * 时间：2020/4/13 21:41
 */
@RestController
@Slf4j
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/payment/nacos/{id}")
	public String getPayment(@PathVariable("id") Integer id){
		String msg = "访问 Linux-Nacos 集群成功,访问ID: " + id;
		log.info(msg);
		return "nacos registry, serverPort：" + serverPort + "<br/>" + msg;
	}
}
