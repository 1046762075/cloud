package com.nay.dome.service;

import com.nay.dome.method.IdGeneratorSnowflake;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: OrderService</p>
 * Description：
 * date：2020/4/15 23:54
 */
@Service
public class OrderService {

	@Resource
	private IdGeneratorSnowflake idGeneratorSnowflake;

	public String getIDBySnowFlake(Integer id){
		ExecutorService threadPool = Executors.newFixedThreadPool(id);
		ArrayList<Long> list = new ArrayList<>();
		list.clear();
		for (int i = 0; i < 4*id; i++) {
			threadPool.submit(() -> {
				list.add(idGeneratorSnowflake.snowflakeId());
			});
		}
		try {
			TimeUnit.MICROSECONDS.sleep(777);
		} catch (InterruptedException e) {}
		list.forEach(System.out::println);
		return "hello snowflake</br>" + list.stream().map(s -> s + "</br>")
				.reduce(String::concat).get();
	}
}
