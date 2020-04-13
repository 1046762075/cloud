package com.nay.springcloud.controller;

import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: ConfigController</p>
 * 作用：
 * 时间：2020/4/13 15:22
 */
@RestController
@Slf4j
@RefreshScope		// 动态刷新
public class ConfigController {

	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/config/info")
	public String getConfigInfo(){
		String msg = configInfo + "\t\t 本次流水ID：<font color='orange'>" + UUID.randomUUID() + "</font>";
		log.info(msg);
		return  msg;
	}
}
