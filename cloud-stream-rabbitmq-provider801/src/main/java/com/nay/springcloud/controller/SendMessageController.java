package com.nay.springcloud.controller;

import com.nay.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>Title: SendMessageController</p>
 * 作用：每访问一次就向 RabbitMQ 发送一次消息
 * 时间：2020/4/12 21:20
 */
@RestController
public class SendMessageController {

	@Value("${server.port}")
	private String serverPort;

	@Resource
	private IMessageProvider iMessageProvider;

	@GetMapping("/sendMessage")
	public String sendMessage(){
		String msg = "生产者admin，------>发送的消息: " + iMessageProvider.send() + "\tport: " + serverPort;
		return "<center><font color='red'>每访问一次就向 RabbitMQ 发送一次消息</font></center>" + msg;
	}
}
