package com.nay.springcloud.dao;

import com.nay.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>Title: PaymentDao</p>
 * 作用：
 * 时间：2020/4/8 14:15
 */
@Mapper
public interface PaymentDao {

	int create(Payment payment);

	Payment getPaymentById(@Param("id") Long id);
}
