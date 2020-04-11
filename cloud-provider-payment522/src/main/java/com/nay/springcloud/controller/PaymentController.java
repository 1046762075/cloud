package com.nay.springcloud.controller;

import com.nay.springcloud.entities.CommonResult;
import com.nay.springcloud.entities.Payment;
import com.nay.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: PaymentController</p>
 * 作用：服务端
 * 时间：2020/4/8 14:52
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

	@Resource
	private PaymentService paymentService;

	@Resource
	private DiscoveryClient discoveryClient;

	@Value("${server.port}")
	private String serverPort;

	@Value("${time}")
	private Integer timeOut;

	@PostMapping(value = "/create")
	public CommonResult create(@RequestBody Payment payment){
		int result = paymentService.create(payment);
		if(result > 0){
			log.info("插入成功,serverPort:" + serverPort);
			return new CommonResult(200,"插入数据库成功",result);
		}else{
			log.info("插入失败");
			return new CommonResult(444,"插入数据库失败",null);
		}
	}

	@GetMapping(value = "/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id){
		Payment payment = paymentService.getPaymentById(id);
		if(payment != null){
			log.info("查询结果：" + payment);
			return new CommonResult(200,"查询成功,来自" + serverPort + "端口",payment);
		}else{
			return new CommonResult(444,"没有对应记录",null);
		}
	}

	@GetMapping(value = "/discovery")
	public Object discovery(){
		List<String> services = discoveryClient.getServices();
		// 获取服务清单列表
		for (String element : services) {
			log.info("*******element:" + element);
		}
		// 获取微服务实例
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		for (ServiceInstance instance : instances) {
			log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
		}
		return this.discoveryClient;
	}

	@GetMapping(value = "/lb")
	public String getPaymentLB(){
		return serverPort;
	}

	@GetMapping(value = "/feign/timeout")
	public String paymentFeignTimeout(){
		try {
			TimeUnit.SECONDS.sleep(timeOut);
			log.info("延迟为：" + timeOut);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "<center><font color='orange'>Feign延迟测试</font></center><br>端口为：" + serverPort;
	}
}
