package com.nay.springcloud.service.impl;

import cn.hutool.core.lang.UUID;
import com.nay.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * <p>Title: IMessageProviderImpl</p>
 * 作用：定义一个消息生产者的发送管道
 * 时间：2020/4/12 21:07
 */
// 定义消息推送管道
@EnableBinding(Source.class)
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

	@Resource
	private MessageChannel output;

	@Override
	public String send() {
		String id = UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(id).build());
		log.info(id);
		return id;
	}
}
