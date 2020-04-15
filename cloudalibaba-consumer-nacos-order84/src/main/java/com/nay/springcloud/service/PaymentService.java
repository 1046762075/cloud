package com.nay.springcloud.service;

import com.nay.springcloud.entities.CommonResult;
import com.nay.springcloud.entities.Payment;
import com.nay.springcloud.service.Impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>Title: PaymentService</p>
 * Description：
 * date：2020/4/14 23:43
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

	/**
	 * 此处URL地址跟603、604的一致
	 */
	@GetMapping("/paymentSQL/{id}")
	CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
