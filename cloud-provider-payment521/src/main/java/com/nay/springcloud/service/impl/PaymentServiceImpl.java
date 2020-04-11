package com.nay.springcloud.service.impl;

import com.nay.springcloud.entities.Payment;
import com.nay.springcloud.dao.PaymentDao;
import com.nay.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>Title: PaymentServiceImpl</p>
 * 作用：
 * 时间：2020/4/8 14:48
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Resource
	private PaymentDao paymentDao;

	@Override
	public int create(Payment payment) {
		return paymentDao.create(payment);
	}

	@Override
	public Payment getPaymentById(long id) {
		return paymentDao.getPaymentById(id);
	}
}
