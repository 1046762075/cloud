package com.nay.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <p>Title: PaymentController</p>
 * 作用：与 Zookeeper 整合
 * 时间：2020/4/9 14:49
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;

	@RequestMapping(value = "/zk")
	public String paymentZk(){
		return "SpringCloud with Zookeeper-Port:" + serverPort + "\t" + UUID.randomUUID().toString().substring(0,5);
	}
}
