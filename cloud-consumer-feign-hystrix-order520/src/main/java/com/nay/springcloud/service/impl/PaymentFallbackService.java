package com.nay.springcloud.service.impl;

import com.nay.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * <p>Title: PaymentFallbackService</p>
 * 作用：
 * 时间：2020/4/10 23:50
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

	@Override
	public String paymentInfo_OK(Integer id) {
		return "----PaymentFallbackService fall back -paymentInfo_OK ^_^";
	}

	@Override
	public String paymentInfo_Timeout(Integer id) {
		return "----PaymentFallbackService fall back -paymentInfo_Timeout (o_o)";
	}
}
