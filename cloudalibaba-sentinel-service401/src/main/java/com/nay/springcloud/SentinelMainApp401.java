package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Title: SentinelMainApp401</p>
 * 作用：Sentinel 监控
 * 			http://127.0.0.1:401/testA
 * 			http://127.0.0.1:401/testB
 * 		流量是控制外部请求给服务清带来的压力
 * 			降级服务
 * 			http://127.0.0.1:401/testD
 * 			异常数 测试  		---我们这次在 Sentinel 中设置的是异常出现5次 就会降级70秒
 * 			http://127.0.0.1:401/testE
 * 			兜底方法
 * 			http://127.0.0.1:401/testHotKey?p1=1&k2=2
 * 			http://127.0.0.1:401/testHotKey?k2=2	不含p1
 * 		 	当参数为128时	QPS可以到15
 * 			http://127.0.0.1:401/testHotKey?p1=128
 * 			按照资源名称限流
 * 			http://127.0.0.1:401/byResource
 * 				否则报：com.alibaba.csp.sentinel.slots.block.flow.FlowException
 * 			按照URL限流
 * 			http://127.0.0.1:401/byUrl
 * 			按照客户自定义限流
 * 			http://127.0.0.1:401/customerBlockHandler
 * 时间：2020/4/13 22:46
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMainApp401 {
	public static void main(String[] args) {
		SpringApplication.run(SentinelMainApp401.class,args);
	}
}
