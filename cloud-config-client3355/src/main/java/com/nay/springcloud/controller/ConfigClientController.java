package com.nay.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: ConfigClientController</p>
 * 作用：
 * 时间：2020/4/12 15:45
 */
@RestController
// 随时监控服务端的更变
@RefreshScope
public class ConfigClientController {

	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/configInfo")
	public String getConfigInfo(){
		return configInfo;
	}
}
