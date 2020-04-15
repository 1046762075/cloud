package com.nay.springcloud.dao;

import com.nay.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * <p>Title: OrderDao</p>
 * Description：
 * date：2020/4/15 15:19
 */
@Mapper
public interface OrderDao {
	//1 新建订单
	void createOrder(Order order);

	//2 修改订单状态 从0改为1
	void update(@Param("userId") Long userId,@Param("status") Integer status);
}