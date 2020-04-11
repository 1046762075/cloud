package com.nay.springcloud.lb.impl;

import com.nay.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Title: MyLB</p>
 * 作用：自己的轮询算法
 * 时间：2020/4/9 22:21
 */
@Component
public class MyLB implements LoadBalancer {

	private AtomicInteger atomicInteger = new AtomicInteger(0);

	/**
	 * 记录上次是第几次来访问
	 */
	public final int getAndIncrement(){
		int current;
		int next;
		do{
			// 获取当前的值
			current = this.atomicInteger.get();
			next = current > 0x7fffffff ? 0 : current + 1;
		}while (!this.atomicInteger.compareAndSet(current,next));
		System.out.println("现在是第" + next + "次访问");
		return next;
	}

	@Override
	public ServiceInstance instances(List<ServiceInstance> instances) {
		int index = getAndIncrement() % instances.size();
		// 这里决定返回第几个服务
		return instances.get(index);
	}
}
