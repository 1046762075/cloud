package com.nay.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>Title: FlowLimitController</p>
 * 作用：监控A、B两个方法
 * 时间：2020/4/13 22:47
 */
@RestController
@Slf4j
public class FlowLimitController {

	@GetMapping("/testA")
	public String testA(){
		String msg = "----------------testA()<font color='red'>打卡成功,可以去访问 http://127.0.0.1:8080 了</font> 时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss"));
		log.info(msg);
		return msg;
	}

	@GetMapping("/testB")
	public String testB(){
		String msg = "----------------testB()<font color='red'>打卡成功,可以去访问 http://127.0.0.1:8080 了</font>时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss"));
		log.info(msg);
		return msg;
	}
}
