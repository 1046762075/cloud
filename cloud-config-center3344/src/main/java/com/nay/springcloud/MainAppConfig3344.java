package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>Title: MainAppConfig3344</p>
 * 作用:	github上的文件更新以后要发送(3355为被刷新的端口)： curl -X POST "http://localhost:3355/actuator/refresh"
 * 		   	github上的文件更新以后要发送(全局刷新)： curl -X POST "http://localhost:3344/actuator/bus-refresh"
 * 		   	github上的文件更新以后要发送(定点刷新,cloud-config-client为SpringCloud名称)： curl -X POST "http://localhost:3344/actuator/bus-refresh/cloud-config-client:3355"
 *
 * 			http://config-3344.com:3344/config-dev.yml
 * 时间：2020/4/12 13:00
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class MainAppConfig3344 {
	public static void main(String[] args) {
		SpringApplication.run(MainAppConfig3344.class,args);
	}
}
