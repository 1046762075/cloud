package com.nay.dome.controller;

import com.nay.dome.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>Title: OrderController</p>
 * Description：
 * date：2020/4/15 23:04
 */
@RestController
public class OrderController {

	@Resource
	private OrderService orderService;

	@GetMapping("/snowflake/{id}")
	public String index(@PathVariable("id") Integer id){
		return orderService.getIDBySnowFlake(id);
	}
}
