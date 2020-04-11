package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>Title: GatewayMain627</p>
 * 作用：网关 这个链接会转发到521的端口上去
 * 		http://127.0.0.1:627/payment/get/1
 * 		动态路由: 需要启动	PayMain_521 、PayMain_522
 * 		http://127.0.0.1:627/payment/lb
 *
 * 		http://127.0.0.1:627/toplist		这个需要联网
 *
 *
 *		curl http://127.0.0.1:627/payment/lb --cookie "username=nay"
 * 		curl http://127.0.0.1:627/payment/lb --cookie "username=nay" -H "ps_nay:123"
 * 		curl http://127.0.0.1:627/payment/lb --cookie "username=nay" -H "ps_nay:123" -H "Host: lsl.nay.com"
 * 		curl http://127.0.0.1:627/payment/lb?age=20 --cookie "username=nay" -H "ps_nay:123" -H "Host: lsl.nay.com"
 * 		!!!!注意: 不需要 web、jar包
 *
 * 时间：2020/4/11 16:37
 */
@EnableEurekaClient
@SpringBootApplication
public class GatewayMain627 {

	public static void main(String[] args) {
		SpringApplication.run(GatewayMain627.class,args);
	}
}
