package com.nay.springcloud.controller;

import com.nay.springcloud.entities.CommonResult;
import com.nay.springcloud.entities.Payment;
import com.nay.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Title: OrderController</p>
 * 作用：客户端
 * 时间：2020/4/8 16:39
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {

	/**
	 * 目标地址
	 */
//	public static final String PAYMENT_URL = "http://localhost:";
//												微服务名称
	public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

	@Resource
	private LoadBalancer loadBalancer;

	@Resource
	private DiscoveryClient discoveryClient;

	/**
	 * Module 之间相互通信
	 */
	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/create")
	public CommonResult<Payment> create(Payment payment){
		System.out.println(payment);
		// 目标地址 -- 参数 -- 返回参数
//		return restTemplate.postForObject(PAYMENT_URL + (521+(int)(Math.random()*2)) + "/payment/create",payment,CommonResult.class);
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
	}

	@GetMapping("/get/{id}")
	public CommonResult<Payment> getPayment1(@PathVariable("id") int id){
//		return restTemplate.getForObject(PAYMENT_URL + (521+(int)(Math.random()*2)) + "/payment/get/" + id,CommonResult.class);
		return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
	}

	@GetMapping("/getForEntity/{id}")
	public CommonResult<Payment> getPayment2(@PathVariable("id") int id){
		ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
		if(entity.getStatusCode().is2xxSuccessful()){
			// 成功返回请求体
			return entity.getBody();
		}else {
			return new CommonResult<>(444,"操作失败");
		}
	}

	/**
	 * 自己的负载均衡
	 * */
	@GetMapping("/lb/{id}")
	public String getPaymentLB(@PathVariable("id") int id){
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		if(instances == null || instances.size() <= 0){
			return null;
		}
		ServiceInstance instance = loadBalancer.instances(instances);
		String http = instance.getUri() + "/payment/get/" + id;
		System.out.println(http);
		return restTemplate.getForObject(http,String.class);
	}
}
