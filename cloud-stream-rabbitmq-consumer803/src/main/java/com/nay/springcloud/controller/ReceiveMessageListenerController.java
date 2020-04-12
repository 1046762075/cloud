package com.nay.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * <p>Title: ReceiveMessageListenerController</p>
 * 作用：接收消息
 * 时间：2020/4/12 22:37
 */
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListenerController {

	@Value("${server.port}")
	private String serverPort;

	/**
	 * 消息输入源
	 */
	@StreamListener(Sink.INPUT)
	public void input(Message<String> message){
		String msg = "消费者lsl，------>接收到的消息: " + message.getPayload() + "\tport: " + serverPort;
		log.info(msg);
	}
}
