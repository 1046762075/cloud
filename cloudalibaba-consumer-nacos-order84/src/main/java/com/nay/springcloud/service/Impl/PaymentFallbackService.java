package com.nay.springcloud.service.Impl;

import com.nay.springcloud.entities.CommonResult;
import com.nay.springcloud.entities.Payment;
import com.nay.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>Title: PaymentFallbackService</p>
 * Description：ribbon VS openFeign
 * date：2020/4/14 22:10
 */
@Component
public class PaymentFallbackService implements PaymentService {

	@Override
	public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
		return new CommonResult<>(444,"此时无一台服务器在线...服务降级返回，------------PaymentFallbackService",new Payment(id,"errorSerial"));
	}
}
