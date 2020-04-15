package com.nay.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.nay.springcloud.entities.CommonResult;
import com.nay.springcloud.entities.Payment;
import com.nay.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>Title: CircleBreakerController</p>
 * Description：
 * date：2020/4/14 22:08
 */
@RestController
@RequestMapping("/consumer")
public class CircleBreakerController {

	private static final String SERVICE_URL = "http://nacos-payment-provider";

	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/fallback/{id}")
//    @SentinelResource(value = "fallback") //没有配置
//    @SentinelResource(value = "fallback",fallback = "handlerFallback") 	// 配置了fallback的,有程序异常了 就会找它
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler") 	// 配置了blockHandler,只负责 Sentinel 控制台配置违规
	@SentinelResource(value = "fallback",fallback = "handlerFallback", blockHandler = "blockHandler") 			// 同时配置 fallback、blockHandler 这样 blockHandler 的权限大于fallback
//	@SentinelResource(value = "fallback",fallback = "handlerFallback", blockHandler = "blockHandler",
//			exceptionsToIgnore = {IllegalArgumentException.class}) 			// exceptionsToIgnore 指定需要排除的异常类
	public CommonResult<Payment> fallback(@PathVariable("id") Long id){
		CommonResult<Payment> commonResult = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class);
		if(id == 4){
			throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
		}else if(commonResult.getData() == null){
			throw new NullPointerException("NullPointerException,没有该ID记录，空指针异常");
		}
		return commonResult;
	}

	/**
	 * 本例是fallback  它会把异常也带进来处理		[专门捕获异常的]
	 */
	public CommonResult handlerFallback(Long id, Throwable ex){
		Payment payment = new Payment(id, null);
		return new CommonResult(444, "兜底异常handler，exception内容" + ex.getMessage(), payment);
	}

	/**
	 * 接管 Sentinel 异常
	 */
	public CommonResult blockHandler(Long id, BlockException exception){
		Payment payment = new Payment(id, null);
		return new CommonResult<>(445, "blockHandler-sentinel 限流，无此流水号：blockException" + exception.getMessage(), payment);
	}

	// --------------- openfeign---------
	@Resource
	private PaymentService paymentService;

	@GetMapping("/paymentSQL/{id}")
	public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
		return paymentService.paymentSQL(id);
	}
}
