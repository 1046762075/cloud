package com.nay.springcloud.service.Impl;

import com.nay.springcloud.dao.OrderDao;
import com.nay.springcloud.entity.Order;
import com.nay.springcloud.service.AccountService;
import com.nay.springcloud.service.OrderService;
import com.nay.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>Title: OrderServiceImpl</p>
 * Description：枯了
 * date：2020/4/15 15:47
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderDao orderDao;

	@Resource
	private StorageService storageService;

	@Resource
	private AccountService accountService;

	@Override
//	开启全局事务
	@GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
	public void create(Order order) {
		log.info("---------->开始新建订单" + order);
		orderDao.createOrder(order);
		log.info("---------->订单微服务开始调用库存做扣减操作");
		storageService.decrease(order.getProductId(),order.getCount());
		log.info("---------->扣减完毕");
		log.info("---------->正在给用户扣减资金....");
		accountService.decrease(order.getUserId(),order.getMoney());
		log.info("---------->用户资金扣减完毕....");
		log.info("---------->正在修改订单状态....");
		orderDao.update(order.getUserId(),0);
		log.info("---------->订单状态修改完成....");
		log.info("---------->交易完成");
	}
}
