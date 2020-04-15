package com.nay.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.nay.springcloud.entities.CommonResult;
import com.nay.springcloud.entities.Payment;
import com.nay.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: RateLimitController</p>
 * 作用：
 * 时间：2020/4/14 19:04
 */
@RestController
public class RateLimitController {

	/**
	 * 设置兜底的方法
	 */
	@SentinelResource(value = "byResource",blockHandler = "handleException")
	@GetMapping("/byResource")
	public CommonResult buResource(){
		return new CommonResult(200,"按照资源名称限流",new Payment(2000,"serial01"));
	}

	public CommonResult handleException(BlockException ex){
		return new CommonResult(444,ex.getClass().getCanonicalName() + "服务不可用");
	}

	@SentinelResource(value = "byUrl")
	@GetMapping("/byUrl")
	public CommonResult byUrl(){
		return new CommonResult(200,"按照URL限流",new Payment(2000,"serial02"));
	}

	/**
	 * 指定兜底方法为 CustomerBlockHandler 类中的 handlerException_bk 方法
	 */
	@SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException_bk")
	@GetMapping("/customerBlockHandler")
	public CommonResult customerBlock(){
		return new CommonResult(200,"按照客户自定义",new Payment(2000,"serial03"));
	}
}
