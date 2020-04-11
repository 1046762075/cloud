package com.nay.springcloud.service;

import com.nay.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * <p>Title: PaymentService</p>
 * 作用：
 * 时间：2020/4/8 14:46
 */
public interface PaymentService {

	int create(Payment payment);

	Payment getPaymentById(@Param("id") long id);
}
