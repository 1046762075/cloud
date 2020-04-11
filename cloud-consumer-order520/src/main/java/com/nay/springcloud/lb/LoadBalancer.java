package com.nay.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * <p>Title: LoadBalancer</p>
 * 作用：
 * 时间：2020/4/9 22:19
 */
public interface LoadBalancer {

	ServiceInstance instances(List<ServiceInstance> instances);
}
