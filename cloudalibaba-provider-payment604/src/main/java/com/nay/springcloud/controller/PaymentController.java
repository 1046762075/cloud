package com.nay.springcloud.controller;

import com.nay.springcloud.entities.CommonResult;
import com.nay.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>Title: PaymentController</p>
 * Description：
 * 			http://127.0.0.1:603/paymentSQL/1
 * date：2020/4/14 21:40
 */
@RestController
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;

	public static HashMap<Long, Payment> hashMap = new HashMap<>();
	static {
		hashMap.put(1L,new Payment(1L,"25d1as5fad58adsasadsafasas31d3as0"));
		hashMap.put(2L,new Payment(2L,"4da5s3dasddas5d5asda4dad5as53das0"));
		hashMap.put(3L,new Payment(3L,"6s5d351as6add3as13a3d1as53d1a53s0"));
	}

	@GetMapping("/paymentSQL/{id}")
	public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
		Payment payment = hashMap.get(id);
		CommonResult<Payment> result = new CommonResult(200, "from mysql ,serverPort: " + serverPort + "\t",payment);
		return result;
	}
}
