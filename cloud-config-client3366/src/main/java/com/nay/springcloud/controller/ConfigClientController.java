package com.nay.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: ConfigClientController</p>
 * 作用：
 * 时间：2020/4/12 17:07
 */
@RestController
@RefreshScope
public class ConfigClientController {

	@Value("${server.port}")
	private String serverPort;

	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/configInfo")
	public String configInfo(){
		return "ServerPort: " + serverPort + "\t\n\n configInfo: " + configInfo;
	}
}