package com.nay.springcloud.controller;

import com.nay.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.Instant;

/**
 * <p>Title: PaymentHystrixController</p>
 * 作用：Hystrix 实现远程调用
 * 时间：2020/4/10 20:43
 */
// 当默认不配置的时候就调用这个方法
@DefaultProperties(defaultFallback = "global_FallbackMethod")
@RestController
@Slf4j
@RequestMapping("/orderHystrix")
public class OrderHystrixController {

	@Resource
	private PaymentHystrixService paymentHystrixService;

	@GetMapping("/ok/{id}")
	public String OK(@PathVariable("id") Integer id){

		return "<center><font color='orange'>来自Hystrix的回复 :</font></center>" + paymentHystrixService.paymentInfo_OK(id);
	}

	@GetMapping(value = "/timeout/{id}")
	public String timeOut(@PathVariable("id") Integer id){
		return "<center><font color='red'>来自Hystrix的回复 :</font></center>" + paymentHystrixService.paymentInfo_Timeout(id);
	}

	/**
	 * 客户端也支持降级
	 */
	@GetMapping("/feign/{id}")
//	@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod" ,commandProperties = {
//			// 这个线程的超时时间是1.02秒 就是说 超过1.02秒就会调用 paymentTimeOutFallbackMethod
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1004")
//	})
//	启用全局 FallbackMethod 方法
	@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1004")
	})
	public String paymentHystrixService(@PathVariable("id") Integer id){
		Instant now = Instant.now();
		String msg =  "<center><font color='red'>来自Hystrix的回复 :</font></center>" + paymentHystrixService.paymentInfo_Timeout(id) + "<br><font color='orange'>客户端去服务端来回: "+ (Duration.between(now,Instant.now()).toMillis()-1000) +"毫秒</font>";
		log.info(msg);
		return msg;
	}

	public String paymentTimeOutFallbackMethod(Integer id){
		Instant now = Instant.now();
		String msg = "客户端访问的人数太多啦 请稍后再来~~~" + "paymentTimeOutFallbackMethod：" + id + "\t 耗时：" + (1000 + Duration.between(now,Instant.now()).toMillis()) + "毫秒";
		log.info(msg);
		return msg;
	}

	public String global_FallbackMethod(){
		Instant now = Instant.now();
		String msg = "服务器异常 请稍后再来~~~" + "global_FallbackMethod：" + "\t 耗时：" + (1000 + Duration.between(now,Instant.now()).toMillis()) + "毫秒";
		log.info(msg);
		return msg;
	}
}
